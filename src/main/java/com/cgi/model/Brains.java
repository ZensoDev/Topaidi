package com.cgi.model;

public class Brains {

	protected Member member;

	public Brains(int idMember) {
		super();
		this.member = new Member(idMember);
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
