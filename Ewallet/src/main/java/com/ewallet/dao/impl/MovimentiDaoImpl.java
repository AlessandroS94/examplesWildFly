package com.ewallet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ewallet.dao.MovimentiDao;
import com.ewallet.model.Movimenti;
import com.ewallet.util.JpaUtil;

public class MovimentiDaoImpl implements MovimentiDao {

	public void save(Movimenti c) {
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

	public List<Movimenti> findAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

		Query query = em.createNamedQuery("Movimenti.findAll");


		return query.getResultList();

		} finally {
		em.close();
		}

		}


}
