package org.eurovending.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.eurovending.model.MachineSerial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class MachineSerialDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

//create	
	@Transactional
	public void createMachineSerial(MachineSerial machineSerial) {
		this.hibernateTemplate.save(machineSerial);
	}
	// insert
	@Transactional
	public void insertMachineSerial(MachineSerial machineSerial) {
		this.hibernateTemplate.saveOrUpdate(machineSerial);
	}
	// delete
	@Transactional
	public void deleteMachineSerial(int idMachineSerial) {
		MachineSerial machineSerial = this.hibernateTemplate.load(MachineSerial.class, idMachineSerial);
		this.hibernateTemplate.delete(machineSerial);
	}
	// get single machine serial
	public MachineSerial getSingleMachineSerial(int idMachineSerial) {
		return this.hibernateTemplate.get(MachineSerial.class, idMachineSerial);
	}
	//get machine serial by serial number
	@Transactional
	public MachineSerial getMachineSerialBySerialNumber(String serialNumber) {
		String hql = "FROM MachineSerial WHERE serialNumber = :serialNumber";
		List<MachineSerial> machineSerials = (List<MachineSerial>) this.hibernateTemplate.find(hql, serialNumber);
		if (machineSerials.size() > 0) {
			return machineSerials.get(0);
		} else {
			return null;
		}
	}
	// get all machine serials
	@Transactional
	public List<MachineSerial> getAllMachineSerials() {
		List<MachineSerial> machineSerials =  this.hibernateTemplate.loadAll(MachineSerial.class);
		return machineSerials;
	}
	

}
