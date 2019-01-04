package com.cgi.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cgi.model.Idea;

public class IdeaDaoImplTest {

	IdeaDaoImpl iDAO;

	@Before
	public void init() {

		iDAO = new IdeaDaoImpl();
	}

	@Test
	public void testFindAll() {
		List<Idea> l = iDAO.findAll();
		org.junit.Assert.assertTrue(l.size() > 0);
	}

	@Test
	public void testFindByKey() {
		List<Idea> l = iDAO.findAll();
		Idea i = iDAO.findByKey(l.get(l.size() - 1).getIdIdea());
		org.junit.Assert.assertTrue(i.getIdIdea() == l.get(l.size() - 1).getIdIdea());
	}
//	

	@Test
	public void testInsert() {
		int size1 = iDAO.findAll().size();

		iDAO.insert(new Idea("Bame"));

		int size2 = iDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 > size1);
	}

	
	@Test
	public void testUpdate() {
		Idea i = iDAO.findAll().get(0);
		String name = i.getTitle();
		i.setTitle("Dwarf");
		iDAO.update(i);

		Idea mDb = iDAO.findByKey(i.getIdIdea());

		Assert.assertFalse(name.equals(mDb.getTitle()));
	}

	@Test
	public void testDelete() {
		List<Idea> l = iDAO.findAll();
		int size1 = l.size();
		Idea i = iDAO.findByKey(l.get(l.size() - 1).getIdIdea());
		iDAO.delete(i);
		int size2 = iDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}

	@Test
	public void testDeleteByKey() {
		List<Idea> l = iDAO.findAll();
		int size1 = l.size();
		iDAO.deleteByKey(l.get(0).getIdIdea());
		int size2 = iDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}
	

}
