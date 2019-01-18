package com.cgi.enumeration;

public enum VoteEnum {
	
	
	Top(1),
	Flop(0);
	
	private int mark;

	private VoteEnum(int mark) {
		this.setMark(mark);
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	

}
