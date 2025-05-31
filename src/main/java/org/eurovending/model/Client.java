package org.eurovending.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String adress;
	private String city;
	private String country;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int id, String name, String adress, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.country = country;
	}
	public Client(String name, String adress, String city, String country) {
		super();
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
	
	
	
	

}
