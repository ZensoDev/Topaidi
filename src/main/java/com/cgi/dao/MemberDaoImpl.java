package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cgi.model.Member;
import com.cgi.utils.Application;

public class MemberDaoImpl implements MemberDao{

	@Override
	public List<Member> findAll() {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		List<Member> l = em.createQuery("select m from Member m").getResultList();

		return l;

	}

	@Override
	public Member findByKey(Integer key) {
		EntityManager em = null;

		EntityManagerFactory emf = Application.getInstance().getEmf();
		em = emf.createEntityManager();

		Member m = em.find(Member.class, key);

		return m;
	}

	@Override
	public void insert(Member obj) {
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
	public void update(Member obj) {
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
	public void delete(Member obj) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Application.getInstance().getEmf();
			em = emf.createEntityManager();

			Member m = em.find(Member.class, obj.getIdMember());

			if (m != null) {
				System.out.println("found");
				em.getTransaction().begin();
				em.remove(m);
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

			Member m = em.find(Member.class, key);

			if (m != null) {
				System.out.println("found");
				em.getTransaction().begin();
				em.remove(m);
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
