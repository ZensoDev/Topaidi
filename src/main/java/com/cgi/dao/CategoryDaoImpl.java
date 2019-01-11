package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Category> findAll() {
		return em.createQuery("from Category c").getResultList();
	}

	@Override
	public Category findByKey(Integer key) {
		return em.find(Category.class, key);
	}

	@Override
	public void insert(Category obj) {
		em.persist(obj);
	}

	@Override
	public void update(Category obj) {
		em.merge(obj);
	}

	@Override
	public void delete(Category obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void deleteByKey(Integer key) {
		em.remove(em.find(Category.class, key));
	}
}
