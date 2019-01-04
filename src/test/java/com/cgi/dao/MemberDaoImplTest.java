package com.cgi.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cgi.model.Member;

public class MemberDaoImplTest {

	MemberDaoImpl mDAO;

	@Before
	public void init() {

		mDAO = new MemberDaoImpl();
	}

	@Test
	public void testFindAll() {
		List<Member> l = mDAO.findAll();
		org.junit.Assert.assertTrue(l.size() > 0);
	}

	@Test
	public void testFindByKey() {
		List<Member> l = mDAO.findAll();
		Member m = mDAO.findByKey(l.get(l.size() - 1).getIdMember());
		org.junit.Assert.assertTrue(m.getIdMember() == l.get(l.size() - 1).getIdMember());
	}
//	

	@Test
	public void testInsert() {
		int size1 = mDAO.findAll().size();

		mDAO.insert(new Member("Bame"));

		int size2 = mDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 > size1);
	}

	
	@Test
	public void testUpdate() {
		Member m = mDAO.findAll().get(0);
		String name = m.getFirstName();
		m.setFirstName("Dwarf");
		mDAO.update(m);

		Member mDb = mDAO.findByKey(m.getIdMember());

		Assert.assertFalse(name.equals(mDb.getFirstName()));
	}

	@Test
	public void testDelete() {
		List<Member> l = mDAO.findAll();
		int size1 = l.size();
		Member m = mDAO.findByKey(l.get(l.size() - 1).getIdMember());
		mDAO.delete(m);
		int size2 = mDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}

	@Test
	public void testDeleteByKey() {
		List<Member> l = mDAO.findAll();
		int size1 = l.size();
		mDAO.deleteByKey(l.get(0).getIdMember());
		int size2 = mDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 < size1);
	}
	

}
