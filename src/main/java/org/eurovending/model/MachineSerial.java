package org.eurovending.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MachineSerial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String serialNumber;
	private String machineType;
	private String machineName;
	private String machineLocation;
	
	public MachineSerial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MachineSerial(int id, String serialNumber, String machineType,
			String machineName, String machineLocation) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.machineType = machineType;
		this.machineName = machineName;
		this.machineLocation = machineLocation;
	}
	public MachineSerial(String serialNumber, String machineType,
			String machineName, String machineLocation) {
		super();
		this.serialNumber = serialNumber;
		this.machineType = machineType;
		this.machineName = machineName;
		this.machineLocation = machineLocation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
		
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getMachineLocation() {
		return machineLocation;
	}
	public void setMachineLocation(String machineLocation) {
		this.machineLocation = machineLocation;
	}


	
}
