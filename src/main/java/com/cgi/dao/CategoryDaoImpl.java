package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cgi.model.Category;
import com.cgi.utils.Application;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> findAll() {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		List<Category> l = em.createQuery("select c from Classe c").getResultList();

		return l;

	}

	@Override
	public Category findByKey(Integer key) {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		Category c = em.find(Category.class, key);

		return c;
	}

	@Override
	public void insert(Category obj) {
		EntityManager em = null;

		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.persist(obj);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void update(Category obj) {
		EntityManager em = null;

		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void delete(Category obj) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			Category c = em.find(Category.class, obj.getIdCat());

			if (c != null) {
				System.out.println("found");
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();
				System.out.println("removed");

			} else {
				System.out.println("not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = null;

		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			Category c = em.find(Category.class, key);

			if (c != null) {
				System.out.println("found");
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();
				System.out.println("removed");

			} else {
				System.out.println("not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}

		}
	}
}
