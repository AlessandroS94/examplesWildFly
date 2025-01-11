package it.example.ewalletrest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
