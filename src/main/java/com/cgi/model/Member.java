package com.cgi.model;

public class Member {

	protected int idMember;
	protected String loginMail;
	protected String password;
	protected String lastName;
	protected String firstName;
	protected boolean admin;

	public Member(int idMember, String loginMail, String password, String lastName, String firstName, boolean admin) {
		super();
		this.idMember = idMember;
		this.loginMail = loginMail;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.admin = admin;
	}

	public Member(int idMember) {
		this.idMember = idMember;
	}

	public void displayMember() {

	}

	public void sort() {

	}

	public void createMember() {

	}

	public void readMember() {

	}

	public void updateMember() {

	}

	public void deleteMember() {

	}

	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", loginMail=" + loginMail + ", password=" + password + ", lastName="
				+ lastName + ", firstName=" + firstName + "]";
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

}
