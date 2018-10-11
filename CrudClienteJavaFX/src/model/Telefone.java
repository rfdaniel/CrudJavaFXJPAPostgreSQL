package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Telefone extends DefaultEntity<Telefone>{

	private static final long serialVersionUID = -5650899726721938227L;

	private String codigoArea;

	private String numero;

	@ManyToOne
	private Cliente cliente;
	
	public Telefone() {
		
	}
	
	public Telefone(String codigoArea, String numero, Cliente cliente) {
		super();
		this.codigoArea = codigoArea;
		this.numero = numero;
		this.cliente = cliente;
	}

	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
