package org.eurovending.dao;

import javax.transaction.Transactional;

import org.eurovending.model.NewMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewMachineDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	// create
	public void createNewMachine(NewMachine newMachine) {
		this.hibernateTemplate.save(newMachine);
	}
	// create or update
	@Transactional
	public void createOrUpdateNewMachine(NewMachine newMachine) {
		this.hibernateTemplate.saveOrUpdate(newMachine);
	}
	// delete
	@Transactional
	public void deleteNewMachine(int idNewMachine) {
		NewMachine newMachine = this.hibernateTemplate.load(NewMachine.class, idNewMachine);
		this.hibernateTemplate.delete(newMachine);
	}
	// get single new machine
	public NewMachine getSingleNewMachine(int idNewMachine) {
		return this.hibernateTemplate.get(NewMachine.class, idNewMachine);
	}
	// get all new machines
	public List<NewMachine> getAllNewMachines() {
		List<NewMachine> newMachines =  this.hibernateTemplate.loadAll(NewMachine.class);
		return newMachines;
	}
	// get all new machines by name
	public List<NewMachine> getAllNewMachinesByName(String name) {
		String hql = "FROM NewMachine WHERE name = :name";
		List<NewMachine> newMachines = (List<NewMachine>) this.hibernateTemplate.find(hql, name);
		return newMachines;
	}
	// drop table
	public void dropNewMachineTable() {
		String hql = "DROP TABLE IF EXISTS new_machine";
		this.hibernateTemplate.bulkUpdate(hql);
	}
	
	
	

}
