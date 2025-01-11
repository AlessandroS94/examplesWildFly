package com.ewallet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ewallet.dao.ContoCorrenteDao;
import com.ewallet.model.ContoCorrente;
import com.ewallet.util.JpaUtil;

public class ContoCorrenteDaoImpl implements ContoCorrenteDao {

	public void save(ContoCorrente c) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(c);

			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();


			

		} finally {
			em.close();
		}

	}

	public void update(ContoCorrente c) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.merge(c);
			transaction.commit();
		} finally {
			em.close();
		}

	}

	public void delete(int idContoCorrente) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			ContoCorrente c = em.find(ContoCorrente.class, idContoCorrente);
			em.remove(c);

			transaction.commit();
		} catch (Exception ex) {
	ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	public ContoCorrente findById(int idContoCorrente) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		ContoCorrente c = em.find(ContoCorrente.class, idContoCorrente);
		System.out.println("Conto Corrente Trovato");
		System.out.println(c);
		return c;
	}

}
