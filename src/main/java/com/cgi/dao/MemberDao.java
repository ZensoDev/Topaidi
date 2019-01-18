package com.cgi.dao;

import com.cgi.model.Member;

public interface MemberDao extends DAOGeneric<Member, Integer>{

	Member findByMail(String loginMail);
	boolean existingMail(String login);
	Member findByMailPwd(String loginMail, String password);
	boolean existingMailPwd(String login, String password);
}
