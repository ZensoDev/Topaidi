package com.cgi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect(
	    "SELECT " +
	    "    brains.member_id as member_iD, " +
	    "    buzz.count as NB_idees " +
	    "FROM "+"brains"
	)
public class BrainsView {
	
	@Id
	private int member_iD;
	
	private int NB_idees;
	
	

	public BrainsView(int member_iD, int nB_idees) {
		super();
		this.member_iD = member_iD;
		NB_idees = nB_idees;
	}

	public int getMember_iD() {
		return member_iD;
	}

	public void setMember_iD(int member_iD) {
		this.member_iD = member_iD;
	}

	public int getNB_idees() {
		return NB_idees;
	}

	public void setNB_idees(int nB_idees) {
		NB_idees = nB_idees;
	}
	
	

	
}
