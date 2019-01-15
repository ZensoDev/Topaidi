package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;
import com.cgi.model.Vote;

@Repository
@Transactional
public class VoteDaoImpl implements VoteDao{
	
	@PersistenceContext
	EntityManager em;

	/*
	 * Method to create one vote and save it in the database
	 * */
	
	@Override
	public void insert(Vote obj) 	{
		em.persist(obj);
		
	}
	
	/*
	 * Method to obtain the view in database to display the Tops classment
	 * 
	 * */
	public List<Idea> topsClassement() {
		return em.createQuery("from top t").getResultList();
	}
	
	
	/*
	 * Method to obtain the view in database to display the Buzz classment
	 * 
	 * */
	public List<Vote> buzzClassement() {
		return em.createQuery("select * from buzz").getResultList();
	}


@Override
public Vote findByKey(Integer key) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void update(Vote obj) {
	// TODO Auto-generated method stub
	
}


@Override
public void delete(Vote obj) {
	// TODO Auto-generated method stub
	
}


@Override
public void deleteByKey(Integer key) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Vote> findAll() {
	// TODO Auto-generated method stub
	return null;
}
}
