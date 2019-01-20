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
import com.cgi.model.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= JpaConfig.class)
@Transactional
public class CommentDaoImplTest {

	    @Autowired
	    CommentDao comDao;
	    
	    Comment com1;
	    Comment com2;
	    Comment com3;
	  

		@Before
		public void init() {

			com1 = new Comment("Pablo");
			com2 = new Comment("Julian");
			com3 = new Comment("Julia");
		}
	    

	    @Test
	    public void testDelete() {

	    	comDao.insert(com1);
	    	comDao.delete(com1);
	        assertNull(comDao.findByKey(com1.getIdCom()));

	    }

	    @Test
	    public void testFindAll() {
	    	int size1 = comDao.findAll().size();

	    	comDao.insert(com1);
	    	comDao.insert(com2);
	    	comDao.insert(com3);

	        int size2 = comDao.findAll().size();
	        
	        assertTrue(size2>size1);

	    }

	    @Test
	    public void testFindByKey() {

	        Comment com = new Comment("Julien");

	        comDao.insert(com);

	        assertNotNull(comDao.findByKey(com.getIdCom()));

	    }

	    @Test

	    public void testInsert() {

	        int size = comDao.findAll().size();

	        comDao.insert(com1);

	        assertNotNull(com1.getIdCom());

	        assertTrue(comDao.findAll().size() == size+1);

	    }

	    @Test
	    public void testUpdate() {

	        comDao.insert(com1);

	        com1.setText("Julian");

	        comDao.update(com1);

	        assertTrue(comDao.findByKey(com1.getIdCom()).getText().equals("Julian"));

	    }
	}

