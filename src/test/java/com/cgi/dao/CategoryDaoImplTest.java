package com.cgi.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cgi.model.Category;


public class CategoryDaoImplTest {

	CategoryDaoImpl cDAO;

	@Before
	public void init() {

		cDAO = new CategoryDaoImpl();
	}

	@Test
	public void testFindAll() {
		List<Category> l = cDAO.findAll();
		org.junit.Assert.assertTrue(l.size() > 0);
	}

	@Test
	public void testFindByKey() {
		List<Category> l = cDAO.findAll();
		Category c = cDAO.findByKey(l.get(l.size() - 1).getIdCat());
		org.junit.Assert.assertTrue(c.getIdCat() == l.get(l.size() - 1).getIdCat());
	}
	

	@Test
	public void testInsert() {
		int size1 = cDAO.findAll().size();

		cDAO.insert(new Category("Bame"));

		int size2 = cDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 > size1);
	}

	
	@Test
	public void testUpdate() {
		Category m = cDAO.findAll().get(0);
		String name = m.getName();
		m.setName("Dwarf");
		cDAO.update(m);

		Category mDb = cDAO.findByKey(m.getIdCat());

		Assert.assertFalse(name.equals(mDb.getName()));
	}

	@Test
	public void testDelete() {
		List<Category> l = cDAO.findAll();
		int size1 = l.size();
		Category m = cDAO.findByKey(l.get(l.size() - 1).getIdCat());
		cDAO.delete(m);
		int size2 = cDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}

	@Test
	public void testDeleteByKey() {
		List<Category> l = cDAO.findAll();
		int size1 = l.size();
		cDAO.deleteByKey(l.get(0).getIdCat());
		int size2 = cDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}
	

}
