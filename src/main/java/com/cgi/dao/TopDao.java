package com.cgi.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;


@Repository
@Transactional
public class TopDao {
	@PersistenceContext
	EntityManager em;
	
	public Map<Idea, BigInteger> topRanking() {
		
		
		List<Object[]> list =em.createNativeQuery("SELECT DISTINCT Idea_id, COUNT(VoteEnum) as Nb_votesTotal FROM vote WHERE VoteEnum = 1 GROUP BY Idea_id ORDER BY COUNT(VoteEnum) DESC LIMIT 10").getResultList();
		Map<Idea,BigInteger > listTop = new HashMap<Idea, BigInteger>();
		for (int i = 0; i < list.size(); i++) {
			listTop.put(em.find(Idea.class,list.get(i)[0]), (BigInteger) list.get(i)[0]);
		}
		return listTop;}
	
	

}
