package com.cgi.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cgi.config.JpaConfig;
import com.cgi.model.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
@Transactional
public class CategoryDaoImplTest {

	@Autowired
	CategoryDao cDao;

	Category categoryTest;
	Category catToTest;
	Category catTest2;

	/**
	 * Creation of instance to avoid database problem
	 */

	@Before
	public void init() {
		categoryTest = new Category("CatTest");
		catToTest = new Category("CatTest2");
		catTest2 = new Category("CatTest3");
	}

	/**
	 * Method to test Insert() Method
	 */
	@Test
	public void testInsert() {
		int size = cDao.findAll().size();
		cDao.insert(categoryTest);
		assertNotNull(categoryTest.getIdCat());
		assertTrue(cDao.findAll().size() == size + 1);
	}

	/**
	 * Method to test FindAll() Method
	 */

	@Test
	public void testFindAll() {
		int size1 = cDao.findAll().size();
		cDao.insert(catToTest);
		int size2 = cDao.findAll().size();
		assertTrue(size2 > size1);

	}

	/**
	 * Method to test FindByKey() Method
	 */
	@Test
	public void testFindByKey() {
		cDao.insert(catToTest);
		assertNotNull(cDao.findByKey(catToTest.getIdCat()));
	}
	/**
	 * Method to test Update() Method
	 */
	@Test
	public void testUpdate() {
		cDao.insert(catTest2);
		catTest2.setName("New Name");
		cDao.update(catTest2);
		assertTrue(cDao.findByKey(catTest2.getIdCat()).getName().equals("New Name"));
	}

	/**
	 * Method to test Delete() Method
	 */
	@Test
	public void testDelete() {
		cDao.insert(categoryTest);
		cDao.delete(categoryTest);
		assertNull(cDao.findByKey(categoryTest.getIdCat()));
	}

	/**
	 * Method to test DeleteByKey() Method
	 */
	@Test
	public void testDeleteByKey() {
		cDao.insert(catTest2);
		cDao.deleteByKey(catTest2.getIdCat());
		assertNull(cDao.findByKey(catTest2.getIdCat()));

		
	}

}

