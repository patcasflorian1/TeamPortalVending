package org.eurovending.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.eurovending.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	// create
	@Transactional
	public void createClient(Client client) {
		this.hibernateTemplate.save(client);
	}
	// create or update
	@Transactional
	public void createOrUpdateClient(Client client) {
		this.hibernateTemplate.saveOrUpdate(client);
	}
	// delete
	@Transactional
	public void deleteClient(int idClient) {
		Client client = this.hibernateTemplate.load(Client.class, idClient);
		this.hibernateTemplate.delete(client);
	}
	// get single client
	@Transactional
	public Client getSingleClient(int idClient) {
		return this.hibernateTemplate.get(Client.class, idClient);
	}
	// get all clients
	@Transactional
	public List<Client> getAllClients() {
		List<Client> clients = this.hibernateTemplate.loadAll(Client.class);
		return clients;
	}
	// get all clients by name
	public List<Client> getAllClientsByName(String name) {
		String hql = "FROM Client WHERE name = :name";
		List<Client> clients = (List<Client>) this.hibernateTemplate.find(hql, name);
		return clients;
	}
	// get all clients by address
	public List<Client> getAllClientsByAddress(String address) {
		String hql = "FROM Client WHERE address = :address";
		List<Client> clients = (List<Client>) this.hibernateTemplate.find(hql, address);
		return clients;
	}
	// get all clients by city
	@Transactional
	public List<Client> getAllClientsByCity(String city) {
		String hql = "FROM Client WHERE city = :city";
		List<Client> clients = (List<Client>) this.hibernateTemplate.find(hql, city);
		return clients;
	}
	// drop table
	@Transactional
	public void dropClientTable() {
		String hql = "DROP TABLE IF EXISTS client";
		this.hibernateTemplate.bulkUpdate(hql);
	}
	

}
