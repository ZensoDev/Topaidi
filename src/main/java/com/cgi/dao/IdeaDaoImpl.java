package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;
import com.cgi.dao.*;


@Repository
@Transactional
public class IdeaDaoImpl implements IdeaDao{

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Idea> findAll() {
		return em.createQuery("select a from Idea a order by date").getResultList();
	}

	@Override
	public Idea findByKey(Integer id) {
		return em.find(Idea.class, id);
	}

	@Override
	public void insert(Idea obj) 	{
		em.persist(obj);
		
	}

	@Override
	public void update(Idea obj) {
		em.merge(obj);
	}

	@Override
	public void delete(Idea obj) {
		Idea aMerged = em.merge(obj);
		em.remove(aMerged);
		
	}

	@Override
	public void deleteByKey(Integer id) {
		Idea aFound = em.find(Idea.class, id);
		em.remove(aFound);
		
	}

//	public int percentage(Idea obj) {
//		TopDao tdao = new TopDao();
//		BuzzDao bDao = new BuzzDao();
//		Idea idea =new Idea();
//		int p1 = tdao.topRanking(idea.getIdIdea()).size()/idea.getVotes().size();
//		
//		return p1;
//	}
	
	public void ranking() {
		
	}
}
