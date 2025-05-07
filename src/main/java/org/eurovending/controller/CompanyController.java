package org.eurovending.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.eurovending.dao.CompanyDao;
import org.eurovending.dao.FillerDAO;
import org.eurovending.dao.UserDao;
import org.eurovending.model.Company;
import org.eurovending.model.Filler;
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
public class CompanyController {
	
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private FillerDAO fillerDao;
	private Filler filler = new Filler("stelian", "0745", "2023-10-01");
	
	@RequestMapping("/")
	public String home(Model model)
	{
		//fillerDao.createFiller(filler);
		List<Company> company= companyDao.getAllCompany();
		List<Users> users = userDao.getAllUsers();
		model.addAttribute("companies", company);
		model.addAttribute("users", users);
		return "index";
	}
	
	//shows add company form 
	@RequestMapping("/add-company")
	public String addCompany(Model model)
	{
		model.addAttribute("title", "Add Company");
		return "add_company";
	}
	
	//handle add company form request
	@RequestMapping(value="/submit-company",  method=RequestMethod.POST)
	public RedirectView handleCompany(@ModelAttribute Company company, HttpServletRequest request)
	{
		companyDao.createCompany(company);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/");
		return redirectView;
	}
	
	//delete handle request
	@RequestMapping("/delete/{companyId}")
	public RedirectView deleteCompany(@PathVariable("companyId") int id, HttpServletRequest request)
	{
		companyDao.deleteCompany(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/");
		return redirectView;
	}
	
	//show update company form
	@RequestMapping("/update/{companyId}")
	public String updateCompanyForm(@PathVariable("companyId") int id, Model model)
	{
		Company company = this.companyDao.getSingleCompany(id);
		model.addAttribute("company", company);
		return "update_company";
	}

}

