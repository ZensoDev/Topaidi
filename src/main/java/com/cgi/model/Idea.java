package com.cgi.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Idea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIdea;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@ManyToOne//(cascade = {CascadeType.ALL})
	@JoinColumn(name = "CAT_ID")
	private Category category;

	@OneToMany(mappedBy = "idea", fetch=FetchType.EAGER)
	private Collection<Comment> comments;

	@ManyToMany
	@JoinTable(name = "IDEA_MEMBER", joinColumns = @JoinColumn(name = "IDEA_ID"), inverseJoinColumns = @JoinColumn(name = "MEMBER_ID"))
	private Collection<Member> members;

	private String title;
	private String photo;
	private String description;
	private boolean state;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@OneToMany(mappedBy = "idea")
	private Collection<Vote> votes;

	public Idea(int idIdea, Member member, Category category, Collection<Comment> comments, String title, String photo,
			String description, boolean state, Date date, Collection<Vote> votes) {
		super();
		this.idIdea = idIdea;
		this.member = member;
		this.category = category;
		this.comments = comments;
		this.title = title;
		this.photo = photo;
		this.description = description;
		this.state = state;
		this.date = date;
		this.votes = votes;
	}

	public Idea(int idIdea, Member member, Category category, String title, String photo, String description,
			boolean state, Date date) {
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
				+ ", title=" + title + ", photo=" + photo + ", description=" + description + ", state=" + state
				+ ", date=" + date + ", votes=" + votes + "]";
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
