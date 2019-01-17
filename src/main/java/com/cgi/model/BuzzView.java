package com.cgi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect(
	    "SELECT " +
	    "    buzz.idea_id as idea_iD, " +
	    "    buzz.count as NB_VotesTotal " +
	    "FROM "+"buzz"
	)
public class BuzzView {
	
	@Id
	private int idea_iD;
	
	private int NB_VotesTotal;
	
	public int getIdea_iD() {
		return idea_iD;
	}

	public void setIdea_iD(int idea_iD) {
		this.idea_iD = idea_iD;
	}

	public int getNB_VotesTotal() {
		return NB_VotesTotal;
	}

	public void setNB_VotesTotal(int nB_VotesTotal) {
		NB_VotesTotal = nB_VotesTotal;
	}

	
}
