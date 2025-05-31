package org.eurovending.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NewMachine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String macMachine;
	private String modelMachine;
	private String signalLevel;
	
	public NewMachine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewMachine(int id, String macMachine, String modelMachine, String signalLevel) {
		super();
		this.id = id;
		this.macMachine = macMachine;
		this.modelMachine = modelMachine;
		this.signalLevel = signalLevel;
	}
	public NewMachine(String macMachine, String modelMachine, String signalLevel) {
		super();
		this.macMachine = macMachine;
		this.modelMachine = modelMachine;
		this.signalLevel = signalLevel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMacMachine() {
		return macMachine;
	}
	public void setMacMachine(String macMachine) {
		this.macMachine = macMachine;
	}
	public String getModelMachine() {
		return modelMachine;
	}
	public void setModelMachine(String modelMachine) {
		this.modelMachine = modelMachine;
	}
	public String getSignalLevel() {
		return signalLevel;
	}
	public void setSignalLevel(String signalLevel) {
		this.signalLevel = signalLevel;
	}
	
	

}
