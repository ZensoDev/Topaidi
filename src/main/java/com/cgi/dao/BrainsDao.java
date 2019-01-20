package com.cgi.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Member;


@Repository
@Transactional
public class BrainsDao {
	
	@PersistenceContext
	EntityManager em;
	
	public Map<Member, BigInteger> brainsRanking() {
		List<Object[]> list = em.createNativeQuery("SELECT DISTINCT count(ididea) compte, Member_id FROM idea i GROUP BY i.member_id ORDER BY compte DESC" ).getResultList();
		Map<Member, BigInteger> listUser = new HashMap<Member, BigInteger>();
		for (int i = 0; i < list.size(); i++) {
			listUser.put(em.find(Member.class, list.get(i)[1]), (BigInteger) list.get(i)[0]);
			
		}			
//		List<BigInteger> listNBIdeas = new ArrayList<>();
//		for (int i = 0; i < list.size(); i++) {
//			listNBIdeas.add( (BigInteger) list.get(i)[0]);
//		}			
		
		return listUser;
	}
	
	public Member findByKey(Integer id) {
		return em.find(Member.class, id);
	}
	
//	public List<BrainsView> brainsMember() {
//				
//		return em.createQuery("SELECT member_id from BrainsView b").getResultList();
//	}
//	public List<BrainsView> brainsIdea() {
//		
//		return em.createQuery("SELECT idea_id from BrainsView b").getResultList();
//	}
//	

}
