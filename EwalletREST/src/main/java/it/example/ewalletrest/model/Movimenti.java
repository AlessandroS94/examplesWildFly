package it.example.ewalletrest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQuery(name="Movimenti.findAll", query="SELECT m FROM Movimenti m")
@Table(name="movimenti")
public class Movimenti implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	private int id;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MOVIMENTO")
	private Date dataMovimento;
	
	private int importo;
	
	
	@ManyToOne
	@JoinColumn(name="ID_CONTO_CORRENTE")
	private ContoCorrente contoCorrente;

	@ManyToOne
	@JoinColumn(name="ID_TIPO_MOVIMENTO")
	private TipoMovimento tipoMovimento;

	
	
	
	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}


	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDataMovimento() {
		return dataMovimento;
	}


	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}


	public int getImporto() {
		return importo;
	}


	public void setImporto(int importo) {
		this.importo = importo;
	}


	public ContoCorrente getContoCorrente() {
		return contoCorrente;
	}


	public void setContoCorrente(ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
	}
	
	
	
	
}
