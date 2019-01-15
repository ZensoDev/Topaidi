package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Comment;
import com.cgi.model.Member;
import com.cgi.utils.Application;

@Transactional
@Repository
public class MemberDaoImpl implements MemberDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Member> findAll() {
		return em.createQuery("from Member").getResultList();
	}

	@Override
	public Member findByKey(Integer key) {
		return em.find(Member.class, key);
	}

	@Override
	public void insert(Member obj) {
		em.persist(obj);
	}

	@Override
	public void update(Member obj) {
		em.merge(obj);
	}

	@Override
	public void delete(Member obj) {
		Member m =em.merge(obj);
		em.remove(m);
	}

	@Override
	public void deleteByKey(Integer key) {
		em.remove(em.find(Member.class, key));
	}

	@Override
	public Member findByMail(String loginMail) {
		return em.find(Member.class, loginMail);
	}
}
