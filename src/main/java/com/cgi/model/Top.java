package com.cgi.model;

import java.sql.Date;

public class Top {

	protected Idea idea;
	protected Date date;

	public Top(int idIdea, Date date) {
		super();
		this.idea = new Idea(idIdea);
		this.date = date;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
