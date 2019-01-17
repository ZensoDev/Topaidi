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
	    "    buzz.count as NB_Votes " +
	    "FROM "+"buzz"
	)
public class BuzzView {
	
	@Id
	private int idea_iD;
	
	public int getIdea_iD() {
		return idea_iD;
	}

	public void setIdea_iD(int idea_iD) {
		this.idea_iD = idea_iD;
	}

	public int getNB_Votes() {
		return NB_Votes;
	}

	public void setNB_Votes(int nB_Votes) {
		NB_Votes = nB_Votes;
	}

	private int NB_Votes;

	@Override
	public String toString() {
		return "BuzzView [idea_ID=" + idea_iD + ", NB_Vote=" + NB_Votes + "]";
	}
}
