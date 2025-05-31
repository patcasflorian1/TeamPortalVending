package org.eurovending.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.eurovending.dao.ElementDAO;
import org.eurovending.model.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ElementController {
	@Autowired
	private ElementDAO elementDao;
	List<Element> elements = new ArrayList<Element>();
	
	// view element
	@RequestMapping("/view-element")
	public String viewElement(Model model) {
		elements = elementDao.getAllElements();
		model.addAttribute("elements", elements);
		return "view_element";
	}
	// add element
	@RequestMapping("/add-element")
	public String addElement(Model model) {
		model.addAttribute("title", "Add Element");
		return "add_element";
	}
	// handle add element form request
	@RequestMapping(value="/submit-element", method=RequestMethod.POST)
	public String handleElement(@ModelAttribute Element element, Model model, HttpServletRequest request) {
		System.out.println("Element: " + element.getName());
		elementDao.createElement(element);
		elements = elementDao.getAllElements();
		model.addAttribute("elements", elements);
		return "view_element";
	}
}
