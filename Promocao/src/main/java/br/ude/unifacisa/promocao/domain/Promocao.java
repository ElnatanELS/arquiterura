package br.ude.unifacisa.promocao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Promocao implements Serializable {

	private static long serialVersionUID = -7799369695818057571L;
	
	@javax.persistence.Id
	private String id;
	private String codigoPromocional;
	private Date dataDeValidade;
	public Promocao(String id, String codigoPromocional, Date dataDeValidade) {
		super();
		this.id = id;
		this.codigoPromocional = codigoPromocional;
		this.dataDeValidade = dataDeValidade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigoPromocional() {
		return codigoPromocional;
	}
	public void setCodigoPromocional(String codigoPromocional) {
		this.codigoPromocional = codigoPromocional;
	}
	public Date getDataDeValidade() {
		return dataDeValidade;
	}
	public void setDataDeValidade(Date dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	
	
	
}
	