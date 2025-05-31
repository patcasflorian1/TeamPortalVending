package org.eurovending.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.eurovending.dao.ClientDAO;
import org.eurovending.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ClientController {
	 List<Client> clients = new ArrayList<Client>();
	@Autowired
	private ClientDAO clientDao;
	
	//view client
	@RequestMapping("/view-client")
	public String viewClient(Model model) {
		clients = clientDao.getAllClients();
		model.addAttribute("clients", clients);
		return "view_client";
	}
   	//add client
	@RequestMapping("/add-client")
	public String addClient(Model model) {
		
		return "add_client";
	}
	//handle add client form request
	@RequestMapping(value="/submit-client", method=RequestMethod.POST)
	public String handleClient(Client client, Model model, HttpServletRequest request) {
		clientDao.createClient(client);
		clients = clientDao.getAllClients();
		
		model.addAttribute("clients", clients);
		return "view_client";
	}
	//update client
	@RequestMapping("/update-client")
	public String updateClient(Model model) {
		clients = clientDao.getAllClients();
		for (Client client : clients) {
			System.out.println(client);
		}
		
		model.addAttribute("clients", clients);
		return "update_client";
	}
	//handle update client form request
	@RequestMapping(value="/submit-update-client")
	public String handleUpdateClient(Client client, Model model) {
		clientDao.createOrUpdateClient(client);
		clients = clientDao.getAllClients();
		
		model.addAttribute("clients", clients);
		return "view_client";
	}
	//delete client
	@RequestMapping("/delete-client")
	public String deleteClient(Model model) {
		clients = clientDao.getAllClients();
		for (Client client : clients) {
			System.out.println(client);
		}
		
		model.addAttribute("clients", clients);
		return "delete_client";
	}
	

}
