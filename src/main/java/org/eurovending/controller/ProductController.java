package org.eurovending.controller;

import java.util.ArrayList;
import java.util.List;

import org.eurovending.dao.ProductDAO;
import org.eurovending.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	Product product = new Product();
	List<Product> products = new ArrayList<Product>();
	ProductDAO productDAO = new ProductDAO();
	@RequestMapping("/view-product")
	public String viewProduct(Model model) {
		// Logic to retrieve and display products
		products = productDAO.getAllProducts();
		model.addAttribute("products", products);
		return "view_product";
	}
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		//model.addAttribute("product", product);
		return "add_product";
	}
	@RequestMapping("/submit-product")
	public String handleProduct(Product product, Model model) {
		productDAO.createOrUpdateProduct(product);
		products = productDAO.getAllProducts();
		model.addAttribute("products", products);
		return "view_product";
	}
	@RequestMapping("/update-product")
	public String updateProduct(Model model) {
		products = productDAO.getAllProducts();
		model.addAttribute("products", products);
		return "update_product";
	}
	//delete product
	@RequestMapping("/delete-product")
	public String deleteProduct(int productId, Model model) {
		productDAO.deleteProduct(productId);
		products = productDAO.getAllProducts();
		model.addAttribute("products", products);
		return "view_product";
	}
	}
	
