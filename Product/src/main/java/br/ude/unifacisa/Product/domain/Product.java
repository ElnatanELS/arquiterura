package br.ude.unifacisa.Product.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@javax.persistence.Id
	private String id;
	private String produtosAdquiridos; 
	private String data;
	
	public Product(String id, String produtosAdquiridos, String data) {
		super();
		this.id = id;
		this.produtosAdquiridos = produtosAdquiridos;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProdutosAdquiridos() {
		return produtosAdquiridos;
	}

	public void setProdutosAdquiridos(String produtosAdquiridos) {
		this.produtosAdquiridos = produtosAdquiridos;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
	

	
	
	
	

}
