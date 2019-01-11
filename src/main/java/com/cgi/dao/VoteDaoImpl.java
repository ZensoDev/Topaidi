package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cgi.model.Vote;

public class VoteDaoImpl implements VoteDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Vote> findAll() {
		return em.createQuery("from Vote v").getResultList();
	}

	@Override
	public Vote findByKey(Integer key) {
		return em.find(Vote.class, key);
	}

	@Override
	public void insert(Vote obj) {
			em.persist(obj);
	}

	@Override
	public void update(Vote obj) {
			em.merge(obj);
	}

	@Override
	public void delete(Vote obj) {
		em.remove(em.find(Vote.class, obj.getIdVote()));
	}

	@Override
	public void deleteByKey(Integer key) {
		em.remove(em.find(Vote.class, key));
	}
}
