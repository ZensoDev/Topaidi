package com.cgi.model;

public class User extends Member{
	
	protected boolean activated;
	
	public User(int idMember, String loginMail, String password, String lastName, String firstName, boolean admin, boolean activated) {
		super(idMember, loginMail, password, lastName, firstName, admin);
		
		this.activated= activated;
	}

	public void vote() {
		
	}
	
public void comment() {
	
}

public boolean isActivated() {
	return activated;
}

public void setActivated(boolean activated) {
	this.activated = activated;
}

}
