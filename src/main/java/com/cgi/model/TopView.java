package com.cgi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect(
	    "SELECT " +
	    "    top.idea_id as idea_ID, " +
	    "    top.count as NB_Vote " +
	    "FROM "+"top"
	)
public class TopView {
	
	@Id
	private int idea_ID;
	

	private int NB_Vote;

	@Override
	public String toString() {
		return "TopView [idea_ID=" + idea_ID + ", NB_Vote=" + NB_Vote + "]";
	}

	public int getIdea_ID() {
		return idea_ID;
	}

	public void setIdea_ID(int idea_ID) {
		this.idea_ID = idea_ID;
	}

	public int getNB_Vote() {
		return NB_Vote;
	}

	public void setNB_Vote(int nB_Vote) {
		NB_Vote = nB_Vote;
	}
	
}
