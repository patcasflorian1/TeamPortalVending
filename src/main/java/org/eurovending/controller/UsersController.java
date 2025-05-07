package org.eurovending.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.eurovending.dao.ConfigMachineDao;
import org.eurovending.dao.UserDao;
import org.eurovending.model.ConfigMachine;
import org.eurovending.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsersController {
@Autowired
private UserDao userDao;
ConfigMachine configMachine = new ConfigMachine("Solista", 1,"Expresso", "CafeaBoabe", 8.5);
private ConfigMachineDao configMachineDao = new ConfigMachineDao();

@RequestMapping("/add-user")
public String addUser(Model model) {
	
	model.addAttribute("nameUser","Add User");
	return "add-user";	
}

@RequestMapping(value="/submit-user",method=RequestMethod.POST)
public RedirectView handleUsers(@ModelAttribute Users user,HttpServletRequest request) throws SQLException {
	userDao.createUser(user);
	//configMachineDao.createConfigMachine(configMachine);
	configMachineDao.insertConfigMachine(configMachine);
	RedirectView redirectView = new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/");
	return redirectView;	
}

@RequestMapping(value="/update-user/{id}")
public String updateUser(@PathVariable("id") int idUser,Model model)
{
	
	Users user = this.userDao.getSingleUser(idUser);
	model.addAttribute("user",user);
	return "update_user";
	
}
@RequestMapping(value="/delete-user/{id}")
public RedirectView deleteUser(@PathVariable("id") int idUser,HttpServletRequest request)
{
	userDao.deleteUser(idUser);
	RedirectView redirectView = new RedirectView();
	redirectView.setUrl(request.getContextPath()+"/");
	return redirectView;
}
}
