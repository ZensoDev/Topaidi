package com.cgi.dao;



import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cgi.model.Comment;

public class CommentDaoImplTest {

	CommentDaoImpl cDAO;

	@Before
	public void init() {

		cDAO = new CommentDaoImpl();
	}

	@Test
	public void testFindAll() {
		List<Comment> l = cDAO.findAll();
		org.junit.Assert.assertTrue(l.size() > 0);
	}

	@Test
	public void testFindByKey() {
		List<Comment> l = cDAO.findAll();
		Comment m = cDAO.findByKey(l.get(l.size() - 1).getIdCom());
		org.junit.Assert.assertTrue(m.getIdCom() == l.get(l.size() - 1).getIdCom());
	}
//	

	@Test
	public void testInsert() {
		int size1 = cDAO.findAll().size();

		cDAO.insert(new Comment("Bame"));

		int size2 = cDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 > size1);
	}

	
	@Test
	public void testUpdate() {
		Comment m = cDAO.findAll().get(0);
		String name = m.getText();
		m.setText("Dwarf");
		cDAO.update(m);

		Comment mDb = cDAO.findByKey(m.getIdCom());

		Assert.assertFalse(name.equals(mDb.getText()));
	}

	@Test
	public void testDelete() {
		List<Comment> l = cDAO.findAll();
		int size1 = l.size();
		Comment m = cDAO.findByKey(l.get(l.size() - 1).getIdCom());
		cDAO.delete(m);
		int size2 = cDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}

	@Test
	public void testDeleteByKey() {
		List<Comment> l = cDAO.findAll();
		int size1 = l.size();
		cDAO.deleteByKey(l.get(0).getIdCom());
		int size2 = cDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}
	

}
