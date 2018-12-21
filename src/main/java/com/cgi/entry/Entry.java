package com.cgi.entry;

import javax.persistence.EntityManagerFactory;

import com.cgi.dao.MemberDao;
import com.cgi.dao.MemberDaoImpl;
import com.cgi.model.Member;
import com.cgi.utils.Application;


public class Entry {

	public static void main(String[] args) {
		
		MemberDao mDao = new MemberDaoImpl();
		
		Member m = new Member("name");
		Member m2 = new Member("na2165me");
		
		mDao.insert(m);
		mDao.insert(m2);
		
		Application.getInstance().getEmf().close();

	}
	
}
