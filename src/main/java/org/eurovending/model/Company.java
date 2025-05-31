package org.eurovending.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "denumire", nullable = false, length = 256)
	private String denumire; // denumire societate
	private String nrONRC; // numar inregistrare onrc
	private String cui; // cui firma
	private String adress; // adresa firma 
	private String dataEntry;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getNrONRC() {
		return nrONRC;
	}
	public void setNrONRC(String nrONRC) {
		this.nrONRC = nrONRC;
	}
	public String getCui() {
		return cui;
	}
	public void setCui(String cui) {
		this.cui = cui;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDataEntry() {
		return dataEntry;
	}
	public void setDataEntry(String dataEntry) {
		this.dataEntry = dataEntry;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Company(String denumire, String nrONRC, String cui, String adress, String dataEntry) {
		super();
		this.denumire = denumire;
		this.nrONRC = nrONRC;
		this.cui = cui;
		this.adress = adress;
		this.dataEntry = dataEntry;
	}
	
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", denumire=" + denumire + ", nrONRC=" + nrONRC +
				", cui=" + cui + ", adress=" + adress + ", dataEntry=" + dataEntry + "]";
	}
	
}

