package com.cgi.model;

import java.util.Date;

public class Idea {
	
	protected int idIdea;
	protected Category category;
	protected Member member;
	protected String title;
	protected String photo;
	protected String description;
	protected boolean state;
	protected Date date;
	
	public Idea(int idIdea, int idMember, Category category, String title, String photo, String description, boolean state,
			Date date) {
		super();
		this.idIdea = idIdea;
		this.member = new Member(idMember);//composition
		this.category = category;
		this.title = title;
		this.photo = photo;
		this.description = description;
		this.state = state;
		this.date = date;
	}
	
	public Idea(int idIdea) {
		this.idIdea=idIdea;
	}
	
	public void displayIdea() {
		
	}
	
	public void createIdea() {
		
	}

	public void readIdea() {

	}
	
	public void updateIdea() {
		
	}
	
	public void deleteIdea() {
		
	}
	
	@Override
	public String toString() {
		return "Idea [idIdea=" + idIdea + ", category=" + category + ", member=" + member + ", title=" + title
				+ ", photo=" + photo + ", description=" + description + ", state=" + state + ", date=" + date + "]";
	}

	public int getIdIdea() {
		return idIdea;
	}

	public void setIdIdea(int idIdea) {
		this.idIdea = idIdea;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
