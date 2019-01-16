package com.cgi.dao;

import java.util.List;

import com.cgi.model.Idea;
import com.cgi.model.Vote;

public interface VoteDao extends DAOGeneric<Vote, Integer>{

	List<Idea> topsClassement();
	List<Idea> buzzClassement();

}
