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

import com.cgi.model.BuzzView;
import com.cgi.model.Idea;
import com.cgi.model.Member;

@Repository
@Transactional
public class BuzzDao {
	@PersistenceContext
	EntityManager em;

	public List<Idea> buzzRanking() {

		List<Object[]> list = em.createNativeQuery(
				"SELECT DISTINCT Idea_id, COUNT(VoteEnum) as NB_votes FROM vote WHERE VoteEnum = 0 OR VoteEnum = 1 GROUP BY Idea_id ORDER BY COUNT(VoteEnum)  DESC LIMIT 10")
				.getResultList();

		List<Idea> listBuzz = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listBuzz.add(em.find(Idea.class,list.get(i)[0]));
		}
		return listBuzz;
	}

}
