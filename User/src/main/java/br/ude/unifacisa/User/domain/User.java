package br.ude.unifacisa.User.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@javax.persistence.Id
	private String id;
	private String name; 
	private String address;
	private String city;
	private String country;
	private String clientProfile;
	
	public User(String id, String name, String address, String city, String country, String clientProfile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.clientProfile = clientProfile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getClientProfile() {
		return clientProfile;
	}

	public void setClientProfile(String clientProfile) {
		this.clientProfile = clientProfile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
