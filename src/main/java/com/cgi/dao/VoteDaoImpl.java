package com.cgi.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;
import com.cgi.model.Vote;


@Repository
@Transactional
public class VoteDaoImpl {
	
	@PersistenceContext
	EntityManager em;

	public List<Vote> findAll() {
		return em.createQuery("select v from Vote v").getResultList();
	}
	/*
	 * Method to create one vote and save it in the database
	 * */
	
	public void insert(Vote obj) 	{
		em.persist(obj);
		
	}
	public Map<Idea, BigInteger> topRanking() {
		
		
		List<Object[]> list =em.createNativeQuery("SELECT DISTINCT COUNT(VoteEnum) as Nb_votesTotal, Idea_id  FROM vote WHERE VoteEnum = 1 GROUP BY Idea_id ORDER BY COUNT(VoteEnum) DESC LIMIT 10").getResultList();
		Map<Idea,BigInteger > listTop = new HashMap<Idea, BigInteger>();
		for (int i = 0; i < list.size(); i++) {
			listTop.put(em.find(Idea.class,list.get(i)[1]), (BigInteger) list.get(i)[0]);
		}
		return listTop;}
	
	
	/*
	 * Method to obtain the view in database to display the Buzz classment
	 * 
	 * */
public Map<Idea, BigInteger> buzzRanking() {

	List<Object[]> list = em.createNativeQuery(
			"SELECT DISTINCT COUNT(VoteEnum) as NB_votes, Idea_id FROM vote WHERE VoteEnum = 0 OR VoteEnum = 1 GROUP BY Idea_id ORDER BY COUNT(VoteEnum)  DESC LIMIT 10")
			.getResultList();

	Map<Idea, BigInteger> listBuzz = new HashMap<Idea, BigInteger>();
	for (int i = 0; i < list.size(); i++) {
		listBuzz.put(em.find(Idea.class,list.get(i)[1]), (BigInteger) list.get(i)[0]);
	}
	return listBuzz;}
}