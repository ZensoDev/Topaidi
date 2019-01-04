package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cgi.model.Comment;
import com.cgi.utils.Application;
public class CommentDaoImpl implements CommentDao{

	@Override
	public List<Comment> findAll() {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		List<Comment> l = em.createQuery("select c from Comment c").getResultList();

		return l;

	}

	@Override
	public Comment findByKey(Integer key) {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		Comment c = em.find(Comment.class, key);

		return c;
	}

	@Override
	public void insert(Comment obj) {
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
	public void update(Comment obj) {
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
	public void delete(Comment obj) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			Comment c = em.find(Comment.class, obj.getIdCom());

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

			Comment c = em.find(Comment.class, key);

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
