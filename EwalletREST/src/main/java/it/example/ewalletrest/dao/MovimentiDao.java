package it.example.ewalletrest.dao;

import it.example.ewalletrest.model.Movimenti;

import java.util.List;

public interface MovimentiDao {
	public void save(Movimenti c);
	public List<Movimenti> findAll();

}
