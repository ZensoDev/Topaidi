package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cgi.model.Vote;
import com.cgi.model.Vote;
import com.cgi.utils.Application;

public class VoteDaoImpl implements VoteDao{

	@Override
	public List<Vote> findAll() {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		List<Vote> l = em.createQuery("select c from Vote c").getResultList();

		return l;

	}

	@Override
	public Vote findByKey(Integer key) {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		Vote c = em.find(Vote.class, key);

		return c;
	}

	@Override
	public void insert(Vote obj) {
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
	public void update(Vote obj) {
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
	public void delete(Vote obj) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			Vote c = em.find(Vote.class, obj.getIdVote());

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

			Vote c = em.find(Vote.class, key);

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
