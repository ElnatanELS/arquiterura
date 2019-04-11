package br.ude.unifacisa.valePresente.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ValePresente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	

	
	@javax.persistence.Id
	private String id;
	private String valor;
	private String senha;
	public ValePresente(String id, String valor, String senha) {
		super();
		this.id = id;
		this.valor = valor;
		this.senha = senha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
	
	
	
	
	
	
	
	
	


