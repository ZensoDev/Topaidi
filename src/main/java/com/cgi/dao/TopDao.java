package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;
import com.cgi.model.TopView;


@Repository
@Transactional
public class TopDao {
	@PersistenceContext
	EntityManager em;
	
	public List<Idea> topRanking() {
		
		
		List<Object[]> list =em.createNativeQuery("SELECT DISTINCT Idea_id, COUNT(VoteEnum) as Nb_votesTotal FROM vote WHERE VoteEnum = 1 GROUP BY Idea_id ORDER BY COUNT(VoteEnum) DESC LIMIT 10").getResultList();
		List<Idea> listTop = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listTop.add(em.find(Idea.class,list.get(i)[0]));
		}
		return listTop;}
	
	

}
