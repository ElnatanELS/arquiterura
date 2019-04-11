package br.ude.unifacisa.promocao.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Promocao implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@javax.persistence.Id
	private String id;
	private String nome;
	
	public Promocao(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
	
	
	
	
	
	
	

}
