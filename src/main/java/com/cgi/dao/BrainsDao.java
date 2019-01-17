package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.BrainsView;


@Repository
@Transactional
public class BrainsDao {
	@PersistenceContext
	EntityManager em;
	
	public List<BrainsView> brainsClassement() {
		
		
		return em.createQuery("from BrainsView b").getResultList();
	}
	

}
