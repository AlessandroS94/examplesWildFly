package com.ewallet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.ewallet.dao.UsersDao;
import com.ewallet.model.ContoCorrente;
import com.ewallet.model.Users;
import com.ewallet.util.JpaUtil;

public class UsersDaoImpl implements UsersDao {

	private String crypto(String pwd) {
		String hash = BCrypt.hashpw(pwd, BCrypt.gensalt());
		return hash;
	}
	public void create(Users u) {
		ContoCorrente c = new ContoCorrente();
		c.setIntestatario(u.getUserName());
		c.setIban(32523534);
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		u.setPassword(crypto(u.getPassword()));
		em.persist(u);
		em.persist(c);
		t.commit();
	}

	public void update(Users u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		u.setPassword(crypto(u.getPassword()));
		em.merge(u);
		t.commit();

	}

	public void delete(int id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Users u = em.find(Users.class, id);
		em.remove(u);
		t.commit();
	}

	public List<Users> findAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createNamedQuery("Users.findAll");
System.out.println("dentroooo");
		List<Users> res = q.getResultList();
		System.out.println(res);	
		 return res;

	}
	
	
	public Users findByUserAndPwd(String user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		
		Query q = em.createQuery(
			    "SELECT c FROM Users c WHERE c.userName = :user")
			    .setParameter("user", user);
		Users res = (Users) q.getSingleResult();
		
		 return res;

	}

		

}
