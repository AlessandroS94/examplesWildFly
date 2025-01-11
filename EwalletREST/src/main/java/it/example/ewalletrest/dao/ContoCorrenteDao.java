package it.example.ewalletrest.dao;

import it.example.ewalletrest.model.ContoCorrente;

public interface ContoCorrenteDao {

		public void save(ContoCorrente c);
		public void update(ContoCorrente c);
		public void delete(int idContoCorrente);
		public ContoCorrente findById(int idContoCorrente);
		
}
