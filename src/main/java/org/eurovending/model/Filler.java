package org.eurovending.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filler {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name; // nume operator care efectueaza inregistrarea
	private String phoneNumber; // numar de telefon operator
	private String dataEntry;
	
	
	public Filler() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Filler(int id, String name, String phoneNumber, String dataEntry) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dataEntry = dataEntry;
	}
	public Filler(String name, String phoneNumber, String dataEntry) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dataEntry = dataEntry;
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
	public String getDataEntry() {
		return dataEntry;
	}
	public void setDataEntry(String dataEntry) {
		this.dataEntry = dataEntry;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
