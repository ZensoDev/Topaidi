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
import com.cgi.model.Vote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= JpaConfig.class)
@Transactional

public class VoteDaoImplTest {

	@Autowired
	VoteDaoImpl vDao;

	Vote vote1;
	Vote vote2;
	Vote vote3;
	

	/**
	 * Creation of instance to avoid database problem
	 */

	@Before
	public void init() {
		vote1 = new Vote();
		vote2 = new Vote();
		vote3 = new Vote();
		// voir comment appeler la vue
	}

	@Test
	public void testInsert() {

		int size = vDao.findAll().size();

		vDao.insert(vote1);

		assertNotNull(vote1.getIdVote());

		assertTrue(vDao.findAll().size() == size + 1);
	}

	@Test
	public void testTopsClassement() {

		int size = 	vDao.topsClassement().size();
		
		vDao.insert(vote1);

		assertTrue(vDao.topsClassement().size() == size + 1);
	}

	@Test
	public void testBuzzClassement() {
		
		int size = 	vDao.buzzClassement().size();
		
		vDao.insert(vote1);
		
		assertTrue(vDao.buzzClassement().size() == size + 1);
	}

}
