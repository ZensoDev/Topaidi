package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;
import com.cgi.model.Vote;
import com.cgi.model.TopView;


@Repository
@Transactional
public class VoteDaoImpl {
	
	@PersistenceContext
	EntityManager em;

	/*
	 * Method to create one vote and save it in the database
	 * */
	
	public void insert(Vote obj) 	{
		em.persist(obj);
		
	}
	
	/*
	 * Method to obtain the view in database to display the Tops classment
	 * 
	 * */
	public List<Idea> topsClassement() {
		return em.createQuery("select t from top t").getResultList();
	}
	
	
	/*
	 * Method to obtain the view in database to display the Buzz classment
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public List<Idea> buzzClassement() {
		return em.createQuery("select b from buzz b").getResultList();
	}

		public List<Vote> findAll() {
		return em.createQuery("select v from Vote v").getResultList();
	}


}
