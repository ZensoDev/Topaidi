package com.cgi.enumeration;

public enum Vote {
	
	
	Top(1),
	Flop(-1),
	Default(0);
	
	private int mark;

	private Vote(int mark) {
		this.setMark(mark);
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	

}
