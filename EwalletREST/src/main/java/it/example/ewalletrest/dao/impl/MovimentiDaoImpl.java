package it.example.ewalletrest.dao.impl;

import it.example.ewalletrest.dao.MovimentiDao;
import it.example.ewalletrest.model.Movimenti;
import it.example.ewalletrest.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

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
