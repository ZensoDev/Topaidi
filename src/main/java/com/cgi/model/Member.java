package com.cgi.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idMember;
	protected String loginMail;
	protected String password;
	protected String lastName;
	protected String firstName;
	protected boolean admin;
	
	@OneToMany(mappedBy="member")
	private Collection<Idea> ideas;
	
	@OneToMany(mappedBy="member")
	private Collection<Comment> comments;
	
	@OneToMany(mappedBy = "member")
	protected Collection<Vote> votes;
	

	public Member(int idMember, String loginMail, String password, String lastName, String firstName, boolean admin,
			Collection<Idea> ideas, Collection<Comment> comments, Collection<Vote> votes) {
		super();
		this.idMember = idMember;
		this.loginMail = loginMail;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.admin = admin;
		this.ideas = ideas;
		this.comments = comments;
		this.votes = votes;
	}

	public Member(int idMember) {
		this.idMember = idMember;
	}

	public Member(String firstName) {
		this.firstName = firstName;
	}
	public Member() {
		super();
	}
	
	

	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", loginMail=" + loginMail + ", password=" + password + ", lastName="
				+ lastName + ", firstName=" + firstName + ", admin=" + admin + ", ideas=" + ideas + ", comments="
				+ comments + "]";
	}

	public void displayMember() {

	}

	public void sort() {

	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public String getLoginMail() {
		return loginMail;
	}

	public void setLoginMail(String loginMail) {
		this.loginMail = loginMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Collection<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Collection<Idea> ideas) {
		this.ideas = ideas;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	public Collection<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}


}
