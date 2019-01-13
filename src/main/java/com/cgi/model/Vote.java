package com.cgi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cgi.enumeration.VoteEnum;


@Entity
public class Vote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idVote;
	
	protected VoteEnum voteEnum;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	protected Member member;
	
	
	@ManyToOne
	@JoinColumn(name = "IDEA_ID")
	protected Idea idea;


	public Vote(VoteEnum voteEnum, Member member, Idea idea) {
		super();
		this.voteEnum = voteEnum;
		this.member = member;
		this.idea = idea;
	}


	public Vote() {
		super();
	}


	public VoteEnum getVoteEnum() {
		return voteEnum;
	}


	public void setVoteEnum(VoteEnum voteEnum) {
		this.voteEnum = voteEnum;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Idea getIdea() {
		return idea;
	}


	public void setIdea(Idea idea) {
		this.idea = idea;
	}


	public int getIdVote() {
		return idVote;
	}


	public void setIdVote(int idVote) {
		this.idVote = idVote;
	}


	
	

}

