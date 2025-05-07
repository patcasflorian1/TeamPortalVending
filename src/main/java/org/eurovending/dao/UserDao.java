package org.eurovending.dao;
import java.util.List;

import javax.transaction.Transactional;


import org.eurovending.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public void createUser(Users user)
	{
		this.hibernateTemplate.saveOrUpdate(user);
	}
	public List<Users> getAllUsers(){
		List<Users> users = this.hibernateTemplate.loadAll(Users.class);
		return users;
	}
	
	@Transactional
	public void deleteUser(int idUser) {
	Users user = this.hibernateTemplate.load(Users.class, idUser);	
	this.hibernateTemplate.delete(user);
	}
	
	@Transactional
	public Users getSingleUser(int idUser) {
		return this.hibernateTemplate.get(Users.class, idUser);
	}
	
	@Transactional
	public void updateUser(Users user) {
		this.hibernateTemplate.update(user);
	}
}
