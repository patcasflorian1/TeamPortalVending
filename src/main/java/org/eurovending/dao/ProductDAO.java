package org.eurovending.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.eurovending.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	// create
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.save(product);
	}
	// create or update
	@Transactional
	public void createOrUpdateProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	// delete
	@Transactional
	public void deleteProduct(int idProduct) {
		Product product = this.hibernateTemplate.load(Product.class, idProduct);
		this.hibernateTemplate.delete(product);
	}
	// get single product
	@Transactional
	public Product getSingleProduct(int idProduct) {
		return this.hibernateTemplate.get(Product.class, idProduct);
	}
	// get all products
	@Transactional
	public List<Product> getAllProducts() {
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	// get all products by name
	@Transactional
	public List<Product> getAllProductsByName(String name) {
		String hql = "FROM Product WHERE productName = :name";
		List<Product> products = (List<Product>)this.hibernateTemplate.find(hql, name);
		return products;
	}
	
	// get all products by description
	@Transactional
		
	public List<Product> getAllProductsByDescription(String description) {
		String hql = "FROM Product WHERE productDescription = :description";
		List<Product> products = (List<Product>) this.hibernateTemplate.find(hql, description);
		return products;
	}
	// get all products by price
	@Transactional
	public List<Product> getAllProductsByPrice(double price) {
		String hql = "FROM Product WHERE productPrice = :price";
		List<Product> products =( List<Product>) this.hibernateTemplate.find(hql, price);
		return products;
	}
	// get all products by price range
	@Transactional
	public List<Product> getAllProductsByPriceRange(double minPrice, double maxPrice) {
		String hql = "FROM Product WHERE productPrice BETWEEN :minPrice AND :maxPrice";
		List<Product> products = (List<Product>) this.hibernateTemplate.find(hql, minPrice, maxPrice);
		return products;
	}
	
	// drop table
	@Transactional
	public void dropProductTable() {
		String hql = "DROP TABLE IF EXISTS product";
		this.hibernateTemplate.bulkUpdate(hql);
	}
}
