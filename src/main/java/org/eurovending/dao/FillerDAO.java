package org.eurovending.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.eurovending.model.Filler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class FillerDAO {
	@Autowired	
	private HibernateTemplate hibernateTemplate;
	// create 
	@Transactional
	
	public void createFiller(Filler filler) {
		this.hibernateTemplate.save(filler);
	}
	//create or update
	
	@Transactional
	public void createOrUpdateFiller(Filler filler) {
		this.hibernateTemplate.saveOrUpdate(filler);
	}
	// delete
	@Transactional
	public void deleteFiller(int idFiller) {
		Filler filler = this.hibernateTemplate.load(Filler.class, idFiller);
		this.hibernateTemplate.delete(filler);
	}
	// get single filler
	public Filler getSingleFiller(int idFiller) {
		return this.hibernateTemplate.get(Filler.class, idFiller);
	}

	// get all fillers
	
	public List<Filler> getAllFillers() {
		List<Filler> fillers = this.hibernateTemplate.loadAll(Filler.class);
		return fillers;
	}
	// get all fillers by name
	
	public List<Filler> getAllFillersByName(String name) {
		String hql = "FROM Filler WHERE name = :name";
		List<Filler> fillers = (List<Filler>) this.hibernateTemplate.find(hql, name);
		return fillers;
	}
	// get all fillers by phone number
	public List<Filler> getAllFillersByPhoneNumber(String phoneNumber) {
		String hql = "FROM Filler WHERE phoneNumber = :phoneNumber";
		List<Filler> fillers = (List<Filler>) this.hibernateTemplate.find(hql, phoneNumber);
		return fillers;
	}
	//drop table
	public void dropFillerTable() {
		String hql = "DROP TABLE IF EXISTS filler";
		this.hibernateTemplate.bulkUpdate(hql);
	}
}
