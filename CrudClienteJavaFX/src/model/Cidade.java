package model;

import javax.persistence.Entity;

@Entity
public class Cidade extends DefaultEntity<Cidade>{
	
	private static final long serialVersionUID = 4617537521195664620L;
	
	private String nomeCidade;
	private String nomeEstado;
	private String nomePais;
	
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public String getNomePais() {
		return nomePais;
	}
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
}
