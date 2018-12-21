package com.cgi.model;

public class Buzz {

	protected Idea idea;

	public Buzz(int idIdea) {
		super();
		this.idea = new Idea(idIdea);
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	
	
}
