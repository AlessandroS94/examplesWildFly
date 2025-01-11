package com.ewallet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name="ContoCorrente.findAll", query="SELECT c FROM ContoCorrente c")
@Table(name="conto_corrente")
public class ContoCorrente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_CREAZIONE")
	private Date dataCreazione;
	
	
	private int iban;
	
	private String intestatario;


	@OneToMany(mappedBy="contoCorrente")
	private List<Movimenti> movimentiS;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public int getIban() {
		return iban;
	}

	public void setIban(int iban) {
		this.iban = iban;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	@Override
	public String toString() {
		return "ContoCorrente [id=" + id + ", dataCreazione=" + dataCreazione + ", iban=" + iban + ", intestatario="
				+ intestatario + ", movimentiS=" + movimentiS + "]";
	}
	
	
	
}
