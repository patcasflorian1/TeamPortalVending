package org.eurovending.controller;

import java.util.ArrayList;
import java.util.List;

import org.eurovending.dao.MachineSerialDAO;
import org.eurovending.model.MachineSerial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MachineSerialController {
	@Autowired
	private MachineSerialDAO machineSerialDao;
	List<MachineSerial> machineSerials = new ArrayList<MachineSerial>();
	
	// view machine serial
	@RequestMapping("/view-machine-serial")
	public String viewMachineSerial(Model model) {
		machineSerials = machineSerialDao.getAllMachineSerials();
		model.addAttribute("machineSerials", machineSerials);
		return "view_machine_serial";
	}
	// add machine serial
	@RequestMapping("/add-machine-serial")
	public String addMachineSerial(Model model) {
		model.addAttribute("title", "Add Machine Serial");
		return "add_machine_serial";
	}
	// handle add machine serial form request
	@RequestMapping(value="/submit-machine-serial", method = RequestMethod.POST)
	public String handleMachineSerial(@ModelAttribute MachineSerial machineSerial, Model model) {
System.out.println("Machine Serial: " + machineSerial.getMachineLocation());
		machineSerialDao.insertMachineSerial(machineSerial);
		machineSerials = machineSerialDao.getAllMachineSerials();
		model.addAttribute("machineSerials", machineSerials);
		return "view_machine_serial";
	}
	
	

}
