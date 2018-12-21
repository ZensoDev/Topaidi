package com.cgi.model;

public class Vote {
	
	protected int idVote;
	protected User user;
	protected Idea idea;
	protected boolean mark;
	
	public Vote(int idVote, User user, Idea idea, boolean mark) {
		super();
		this.idVote = idVote;
		this.user = user;
		this.idea = idea;
		this.mark = mark;
	}
	
	
	

}
