package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.cgi.model.Comment;
import com.cgi.utils.Application;

@Transactional
@Repository
public class CommentDaoImpl implements CommentDao{

	@PersistenceContext
	EntityManager em;
	
	
	public List<Comment> findAll() {
		return em.createQuery("from Comment").getResultList();

	}

	
	public Comment findByKey(Integer key) {
		return em.find(Comment.class, key);
	}

	
	public void insert(Comment obj) {
		em.persist(obj);
	}

	
	public void update(Comment obj) {
		em.merge(obj);
	}

	
	public void delete(Comment obj) {
		Comment c =em.merge(obj);
		em.remove(c);
	}

	
	public void deleteByKey(Integer key) {
		em.remove(em.find(Comment.class, key));
	}
}
