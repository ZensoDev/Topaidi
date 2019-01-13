package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Vote;

@Repository
@Transactional
public class VoteDaoImpl implements VoteDao{
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Vote> findAll() {
		return em.createQuery("select v from Vote v").getResultList();
	}

	@Override
	public Vote findByKey(Integer id) {
		return em.find(Vote.class, id);
	}

	@Override
	public void insert(Vote obj) 	{
		em.persist(obj);
		
	}

	@Override
	public void update(Vote obj) {
		em.merge(obj);
	}

	@Override
	public void delete(Vote obj) {
		Vote vMerged = em.merge(obj);
		em.remove(vMerged);
		
	}

	@Override
	public void deleteByKey(Integer id) {
		Vote vFound = em.find(Vote.class, id);
		em.remove(vFound);
		
	}
}
