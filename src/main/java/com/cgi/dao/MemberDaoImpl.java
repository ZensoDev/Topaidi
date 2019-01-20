package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Comment;
import com.cgi.model.Member;
import com.cgi.utils.Application;

@Transactional
@Repository
public class MemberDaoImpl implements MemberDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Member> findAll() {
		return em.createQuery("from Member").getResultList();
	}

	@Override
	public Member findByKey(Integer key) {
		return em.find(Member.class, key);
	}

	@Override
	public void insert(Member obj) {
		em.persist(obj);
	}

	@Override
	public void update(Member obj) {
		em.merge(obj);
	}

	@Override
	public void delete(Member obj) {
		Member m =em.merge(obj);
		em.remove(m);
	}

	@Override
	public void deleteByKey(Integer key) {
		em.remove(em.find(Member.class, key));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Member findByMail(String login) {
		
		Member member = new Member();
		List<Member> memberList =  em.createQuery("SELECT m FROM Member m WHERE m.loginMail = :login")
				.setParameter("login", login)
				.getResultList();
		
		if(memberList.isEmpty()) {
			return null;
		}else {
			return memberList.get(0);
		}
	}

	@Override
	public boolean existingMail(String login) {
		boolean result = true;
		if (findByMail(login) == null) {
			result=false;
		}
		return result;
	}
	
	@Override
	public Member findByMailPwd(String login, String password) {
		
		Member member = new Member();
		member = (Member) em.createQuery("SELECT m FROM Member m WHERE m.loginMail = :login AND m.password = :password")
				.setParameter("login", login)
				.setParameter("password", password)
				.getSingleResult();
		
		return member;
	}

	@Override
	public boolean existingMailPwd(String login, String password) {
		boolean result = true;
		if (findByMailPwd(login, password) == null) {
			result=false;
		}
		return result;
	}

	@Override
	public void activate(Member member) {
		// TODO Auto-generated method stub
		em.createQuery("UPDATE member SET state = :state WHERE member.idmember = memberid")
		.setParameter("state", "false")
		.setParameter("memberid", member.getIdMember());
	}

	@Override
	public void desactivate(Member member) {
		// TODO Auto-generated method stub
		em.createQuery("UPDATE member SET state = :state WHERE member.idmember = memberid")
		.setParameter("state", "true")
		.setParameter("memberid", member.getIdMember());
	}
	
	@Override
	public void activateAdmin(Member member) {
		// TODO Auto-generated method stub
		em.createQuery("UPDATE member SET admin = :admin WHERE member.idmember = memberid")
		.setParameter("admin", "true")
		.setParameter("memberid", member.getIdMember());
	}

	@Override
	public void desactivateAdmin(Member member) {
		// TODO Auto-generated method stub
		em.createQuery("UPDATE member SET admin = :admin WHERE member.idmember = memberid")
		.setParameter("admin", "false")
		.setParameter("memberid", member.getIdMember());
	}
	
	@Override
	public Member findByMailMember(String login) {
		
		Member member = new Member();
		member = (Member) em.createQuery("SELECT m FROM Member m WHERE m.loginMail = :login")
				.setParameter("login", login)
				.getSingleResult();
		
		return member;
	}
	
}
