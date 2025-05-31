package org.eurovending.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.eurovending.dao.NewMachineDAO;
import org.eurovending.model.NewMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewMachineController {
	@Autowired
	private NewMachineDAO configNewMachineDao;
	List<NewMachine> newMachines = new ArrayList<NewMachine>();
	// create new machine
	@RequestMapping(value="/view-new-machine")
	public String viewNewMachine( Model model) {
		newMachines =  configNewMachineDao.getAllNewMachines();
		model.addAttribute("newMachines", newMachines);
		return "view-new-machine";
	}
	// add new machine
	@RequestMapping(value="/add-new-machine")
	public String addNewMachine(Model model) {
		model.addAttribute("title", "Add New Machine");
		return "add-new-machine";
	}
	// handle add new machine form request
	@RequestMapping(value="/submit-new-machine", method=RequestMethod.POST)
	public String handleNewMachine(@ModelAttribute NewMachine newMachine, Model model, HttpServletRequest request) {
		System.out.println("New Machine: " + newMachine.getMacMachine());
		configNewMachineDao.createOrUpdateNewMachine(newMachine);
		newMachines = configNewMachineDao.getAllNewMachines();
		model.addAttribute("	", newMachines);
		return "view-new-machine";
	}
	
	
	

}
