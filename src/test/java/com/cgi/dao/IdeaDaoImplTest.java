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
import com.cgi.model.Idea;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= JpaConfig.class)
@Transactional
public class IdeaDaoImplTest {

	    @Autowired
	    IdeaDao ideaDao;
	    
	    Idea idea1;
	    Idea idea2;
	    Idea idea3;
	  

		@Before
		public void init() {

			idea1 = new Idea("Pablo");
			idea2 = new Idea("Julian");
			idea3 = new Idea("Julia");
		}
	    

	    @Test
	    public void testDelete() {

	        ideaDao.insert(idea1);
	        ideaDao.delete(idea1);
	        assertNull(ideaDao.findByKey(idea1.getIdIdea()));

	    }

	    @Test
	    public void testFindAll() {
	    	int size1 = ideaDao.findAll().size();

	        ideaDao.insert(idea1);
	        ideaDao.insert(idea2);
	        ideaDao.insert(idea3);

	        int size2 = ideaDao.findAll().size();
	        
	        assertTrue(size2>size1);

	    }

	    @Test
	    public void testFindByKey() {

	        Idea idea = new Idea("Julien");

	        ideaDao.insert(idea);

	        assertNotNull(ideaDao.findByKey(idea.getIdIdea()));

	    }

	    @Test

	    public void testInsert() {

	        int size = ideaDao.findAll().size();

	        ideaDao.insert(idea1);

	        assertNotNull(idea1.getIdIdea());

	        assertTrue(ideaDao.findAll().size() == size+1);

	    }

	    @Test
	    public void testUpdate() {

	        ideaDao.insert(idea1);

	        idea1.setTitle("Julian");

	        ideaDao.update(idea1);

	        assertTrue(ideaDao.findByKey(idea1.getIdIdea()).getTitle().equals("Julian"));

	    }
	}

