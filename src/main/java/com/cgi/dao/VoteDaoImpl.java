package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
<<<<<<< Updated upstream
=======
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
>>>>>>> Stashed changes

import com.cgi.model.Vote;

@Repository
@Transactional
public class VoteDaoImpl implements VoteDao{
	
	@PersistenceContext
	EntityManager em;

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vote> findAll() {
<<<<<<< Updated upstream
		return em.createQuery("from Vote v").getResultList();
	}

	@Override
	public Vote findByKey(Integer key) {
		return em.find(Vote.class, key);
	}

	@Override
	public void insert(Vote obj) {
			em.persist(obj);
=======
		return em.createQuery("select v from Vote v").getResultList();
	}

	@Override
	public Vote findByKey(Integer id) {
		return em.find(Vote.class, id);
	}

	@Override
	public void insert(Vote obj) 	{
		em.persist(obj);
		
>>>>>>> Stashed changes
	}

	@Override
	public void update(Vote obj) {
<<<<<<< Updated upstream
			em.merge(obj);
=======
		em.merge(obj);
>>>>>>> Stashed changes
	}

	@Override
	public void delete(Vote obj) {
<<<<<<< Updated upstream
		em.remove(em.find(Vote.class, obj.getIdVote()));
	}

	@Override
	public void deleteByKey(Integer key) {
		em.remove(em.find(Vote.class, key));
=======
		Vote vMerged = em.merge(obj);
		em.remove(vMerged);
		
	}

	@Override
	public void deleteByKey(Integer id) {
		Vote vFound = em.find(Vote.class, id);
		em.remove(vFound);
		
>>>>>>> Stashed changes
	}
}
