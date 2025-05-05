package org.eurovending.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MachineInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
public String macMachine;
private String locationName;
private int signalLevel;

public int getId() {
	return id;
}

public String getMacMachine() {
	return macMachine;
}

public void setMacMachine(String macMachine) {
	this.macMachine = macMachine;
}

public String getLocationName() {
	return locationName;
}

public void setLocationName(String locationName) {
	this.locationName = locationName;
}

public int getSignalLevel() {
	return signalLevel;
}

public void setSignalLevel(int signalLevel) {
	this.signalLevel = signalLevel;
}

public void setId(int id) {
	this.id = id;
}

public MachineInterface() {
	super();
	// TODO Auto-generated constructor stub
}

public MachineInterface(int id, String macMachine, String locationName, int signalLevel) {
	super();
	this.id = id;
	this.macMachine = macMachine;
	this.locationName = locationName;
	this.signalLevel = signalLevel;
}


}
