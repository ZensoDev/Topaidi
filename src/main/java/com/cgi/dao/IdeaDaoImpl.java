package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cgi.model.Idea;
import com.cgi.utils.Application;

public class IdeaDaoImpl implements IdeaDao{

	@Override
	public List<Idea> findAll() {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		List<Idea> l = em.createQuery("select i from Idea i").getResultList();

		return l;

	}

	@Override
	public Idea findByKey(Integer key) {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		Idea i = em.find(Idea.class, key);

		return i;
	}

	@Override
	public void insert(Idea obj) {
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
	public void update(Idea obj) {
		EntityManager em = null;

		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			Idea i = em.find(Idea.class, obj.getIdIdea());
			em.getTransaction().begin();
			em.merge(i);
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
	public void delete(Idea obj) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			Idea i = em.find(Idea.class, obj.getIdIdea());

			if (i != null) {
				System.out.println("found");
				em.getTransaction().begin();
				em.remove(i);
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

			Idea i = em.find(Idea.class, key);

			if (i != null) {
				System.out.println("found");
				em.getTransaction().begin();
				em.remove(i);
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
