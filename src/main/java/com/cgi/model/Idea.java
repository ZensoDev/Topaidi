package com.cgi.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Idea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idIdea;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	protected Member member;

	@ManyToOne
	@JoinColumn(name = "CAT_ID")
	protected Category category;

	@OneToMany(mappedBy = "idea")
	private Collection<Comment> comments;

	@ManyToMany
	@JoinTable(name = "IDEA_MEMBER", 
	joinColumns = @JoinColumn(name = "IDEA_ID"), 
	inverseJoinColumns = @JoinColumn(name = "MEMBER_ID"))
	private Collection<Member> members;

	protected String title;
	protected String photo;
	protected String description;
	protected boolean state;
	protected Date date;
	
	@OneToMany(mappedBy = "idea")
	protected Collection<Vote> votes;
	
	
	public Idea(int idIdea, Member member, Category category, Collection<Comment> comments, Collection<Member> members,
			String title, String photo, String description, boolean state, Date date, Collection<Vote> votes) {
		super();
		this.idIdea = idIdea;
		this.member = member;
		this.category = category;
		this.comments = comments;
		this.members = members;
		this.title = title;
		this.photo = photo;
		this.description = description;
		this.state = state;
		this.date = date;
		this.votes = votes;
	}

	public Idea(int idIdea, Member member, Category category, String title, String photo, String description, boolean state, Date date) {
		super();
		this.idIdea = idIdea;
		this.member = member;
		this.category = category;
		this.title = title;
		this.photo = photo;
		this.description = description;
		this.state = state;
		this.date = date;
	}

	public Idea(int idIdea) {
		this.idIdea = idIdea;
	}
	

	public Idea() {
		super();
	}
	

	public Idea(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Idea [idIdea=" + idIdea + ", member=" + member + ", category=" + category + ", comments=" + comments
				+ ", members=" + members + ", title=" + title + ", photo=" + photo + ", description=" + description
				+ ", state=" + state + ", date=" + date + ", votes=" + votes + "]";
	}

	public void displayIdea() {

	}

	public int getIdIdea() {
		return idIdea;
	}

	public void setIdIdea(int idIdea) {
		this.idIdea = idIdea;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	public Collection<Member> getMembers() {
		return members;
	}

	public void setMembers(Collection<Member> members) {
		this.members = members;
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

	public Collection<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}

	

	
}
