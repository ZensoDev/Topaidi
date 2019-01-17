package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.BuzzView;


@Repository
@Transactional
public class BuzzDao {
	@PersistenceContext
	EntityManager em;
	
	public List<BuzzView> buzzClassement() {
		
		
		return em.createQuery("from BuzzView b").getResultList();
	}
	

}
