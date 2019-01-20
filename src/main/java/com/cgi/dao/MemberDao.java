package com.cgi.dao;

import com.cgi.model.Member;

public interface MemberDao extends DAOGeneric<Member, Integer>{

	Member findByMail(String loginMail);
	boolean existingMail(String login);
	Member findByMailPwd(String loginMail, String password);
	boolean existingMailPwd(String login, String password);
	void activate(Member member);
	void desactivate(Member member);
	void activateAdmin(Member member);
	void desactivateAdmin(Member member);
	Member findByMailMember(String login);
}
