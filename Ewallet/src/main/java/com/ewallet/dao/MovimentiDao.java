package com.ewallet.dao;

import java.util.List;

import com.ewallet.model.Movimenti;

public interface MovimentiDao {
	public void save(Movimenti c);
	public List<Movimenti> findAll();

}
