package com.cgi.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cgi.model.Member;

public class MemberDaoImplTest {

	MemberDaoImpl mDAO;
	Member m1;

	@Before
	public void init() {

		mDAO = new MemberDaoImpl();
		m1 = new Member("Pablo");
	}

	@Test
	public void testFindAll() {
		List<Member> l = mDAO.findAll();
		mDAO.insert(m1);
		org.junit.Assert.assertFalse(!l.isEmpty()); // on vérifie si bien insert dans liste
	}

	@Test
	public void testFindByKey() {
		List<Member> l = mDAO.findAll();
		mDAO.insert(m1);
		Member m = mDAO.findByKey(m1.getIdMember());
		org.junit.Assert.assertTrue(m.getIdMember() == m1.getIdMember());
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

		List<Member> l = mDAO.findAll();
		mDAO.insert(m1);
		Member m = mDAO.findByKey(l.get(l.size() - 1).getIdMember());
		String name = m.getFirstName();
		m.setFirstName("Dwarf");
		mDAO.update(m);

		Member mDb = mDAO.findByKey(m.getIdMember());

		Assert.assertFalse(m1.getFirstName().equals(mDb.getFirstName()));
	}

	@Test
	public void testDelete() {
		List<Member> l = mDAO.findAll();
		mDAO.insert(m1);
		int size1 = l.size();
		Member m = mDAO.findByKey(l.get(l.size() - 1).getIdMember());
		mDAO.delete(m);
		int size2 = mDAO.findAll().size();
		org.junit.Assert.assertTrue(size2 == size1);
	}

	@Test
	public void testDeleteByKey() {
		List<Member> l = mDAO.findAll();
		int size1 = l.size();
		mDAO.insert(m1);
		int size2 = mDAO.findAll().size();
		org.junit.Assert.assertFalse(size2 == size1);
		mDAO.deleteByKey(m1.getIdMember());
		org.junit.Assert.assertTrue(size1 == mDAO.findAll().size());
		
	}

}
