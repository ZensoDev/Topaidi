package com.cgi.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgi.model.Vote;

public class VoteDaoImplTest {

	@Autowired
	VoteDao vDao;

	Vote voteTest;
	Vote voteTest2;
	Vote voteTest3;

	/**
	 * Creation of instance to avoid database problem
	 */

	@Before
	public void init() {
		voteTest = new Vote();
		//voir comment appeler la vue
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testTopsClassement() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuzzClassement() {
		fail("Not yet implemented");
	}


}

