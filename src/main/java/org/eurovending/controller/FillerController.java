package org.eurovending.controller;

import java.util.ArrayList;
import java.util.List;

import org.eurovending.dao.FillerDAO;
import org.eurovending.model.Filler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FillerController {
	List<Filler> fillers = new ArrayList<Filler>();
	@Autowired
	private FillerDAO fillerDao;
	
	//view filler
	@RequestMapping("/view-filler")
	public String viewFiller(Model model) {
		fillers = fillerDao.getAllFillers();
		model.addAttribute("fillers", fillers);
		return "view_filler";
	}
  	//add filler
	@RequestMapping("/add-filler")
	public String addFiller(Model model) {
		model.addAttribute("title", "Add Filler");
		return "add_filler";
	}
	//handle add filler form request
	@RequestMapping(value="/submit-filler")
	public String handleFiller(Filler filler, Model model) {
		fillerDao.createFiller(filler);
		fillers = fillerDao.getAllFillers();
		
		model.addAttribute("fillers", fillers);
		return "view_filler";
	}
	//update filler
	@RequestMapping("/update-filler")
	public String updateFiller(Model model) {
		fillers = fillerDao.getAllFillers();
		for (Filler filler : fillers) {
			System.out.println(filler);
		}
		
		model.addAttribute("fillers", fillers);
		return "update_filler";
	}
	//handle update filler form request
	@RequestMapping(value="/submit-update-filler")
	public String handleUpdateFiller(Filler filler, Model model) {
		fillerDao.createOrUpdateFiller(filler);
		fillers = fillerDao.getAllFillers();
		
		model.addAttribute("fillers", fillers);
		return "view_filler";
	}
	//delete filler
	@RequestMapping("/delete-filler")
	public String deleteFiller(Model model) {
		fillers = fillerDao.getAllFillers();
		for (Filler filler : fillers) {
			System.out.println(filler);
		}
		
		model.addAttribute("fillers", fillers);
		return "delete_filler";
	}
	
	
	
}
