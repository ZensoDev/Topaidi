package com.cgi.model;

import java.util.Date;

public class Comment {
	
	protected int idCom;
	protected Member member;
	protected Idea idea;
	protected Date date;
	protected String text;
	
	public Comment(int idCom, int idMember, int idIdea, Date date, String text) {
		super();
		this.idCom = idCom;
		this.member = new Member(idMember);
		this.idea = new Idea(idIdea);
		this.date = date;
		this.text = text;
	}

	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	

}
