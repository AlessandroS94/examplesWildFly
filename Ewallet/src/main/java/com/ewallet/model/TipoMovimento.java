package com.ewallet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_movimento")
public class TipoMovimento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_MOVIMENTO")
	private int idTipoMovimento;
	
	private String descrizione;

	@OneToMany(mappedBy="tipoMovimento")
	private List<Movimenti> movimentiS;
	
	public int getIdTipoMovimento() {
		return idTipoMovimento;
	}

	public void setIdTipoMovimento(int idTipoMovimento) {
		this.idTipoMovimento = idTipoMovimento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
