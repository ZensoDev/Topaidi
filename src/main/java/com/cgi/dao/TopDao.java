package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.TopView;


@Repository
@Transactional
public class TopDao {
	@PersistenceContext
	EntityManager em;
	
	public List<TopView> topClassement() {
		
		
		return em.createQuery("from TopView t").getResultList();
	}
	public List<TopView> topRanking(Integer id) {
		
		
		return em.createQuery("SELECT DISTINCT Idea_id from TopView t where idea8id =").getResultList();
	}
	
	
	

}
