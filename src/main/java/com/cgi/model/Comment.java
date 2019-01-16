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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idCom;
	
	@ManyToOne
	@JoinColumn(name="IDEA_ID")
	protected Idea idea;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	protected Member member;
	
	@ManyToMany
	@JoinTable( name="COMMENT_MEMBER",
	joinColumns	=@JoinColumn(name="COMMENT_ID"	),
	inverseJoinColumns	=@JoinColumn(name=	"MEMBER_ID"))
	private Collection<Member> members;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected Date date;
	protected String text;
	
	
	
	public Comment(int idCom, Idea idea, Member member, Collection<Member> members, Date date, String text) {
		super();
		this.idCom = idCom;
		this.idea = idea;
		this.member = member;
		this.members = members;
		this.date = date;
		this.text = text;
	}


	public Comment() {
		super();
	}


	public Comment(String text) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Comment [idCom=" + idCom + ", idea=" + idea + ", member=" + member + ", members=" + members + ", date="
				+ date + ", text=" + text + "]";
	}


	public int getIdCom() {
		return idCom;
	}


	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}


	public Idea getIdea() {
		return idea;
	}


	public void setIdea(Idea idea) {
		this.idea = idea;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Collection<Member> getMembers() {
		return members;
	}


	public void setMembers(Collection<Member> members) {
		this.members = members;
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
