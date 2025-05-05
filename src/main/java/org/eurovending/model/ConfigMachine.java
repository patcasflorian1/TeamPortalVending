package org.eurovending.model;




public class ConfigMachine  {
	private int id;
	private String nameMachine;
	private int numberOfProducts;
	private String nameOfProductsFinal;
	private String nameOfProducts;
	private double quantityOfProducts;
	

	public ConfigMachine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfigMachine(int id, int numberOfProducts,
			String nameOfProductsFinal, String nameOfProducts, double quantityOfProducts) {
		super();
		this.id = id;
		this.numberOfProducts = numberOfProducts;
		this.nameOfProductsFinal = nameOfProductsFinal;
		this.nameOfProducts = nameOfProducts;
		this.quantityOfProducts = quantityOfProducts;
	}
	
	public ConfigMachine( int numberOfProducts,
			String nameOfProductsFinal, String nameOfProducts, double quantityOfProducts) {
		super();	
		this.numberOfProducts = numberOfProducts;
		this.nameOfProductsFinal = nameOfProductsFinal;
		this.nameOfProducts = nameOfProducts;
		this.quantityOfProducts = quantityOfProducts;
	}
	public ConfigMachine(int id, String nameMachine, int numberOfProducts,
			String nameOfProductsFinal, String nameOfProducts, double quantityOfProducts) {
		super();
		this.id = id;
		this.nameMachine = nameMachine;
		this.numberOfProducts = numberOfProducts;
		this.nameOfProductsFinal = nameOfProductsFinal;
		this.nameOfProducts = nameOfProducts;
		this.quantityOfProducts = quantityOfProducts;
	}
	
	public ConfigMachine(String nameMachine, int numberOfProducts,
			String nameOfProductsFinal, String nameOfProducts, double quantityOfProducts) {
		super();
		this.nameMachine = nameMachine;
		this.numberOfProducts = numberOfProducts;
		this.nameOfProductsFinal = nameOfProductsFinal;
		this.nameOfProducts = nameOfProducts;
		this.quantityOfProducts = quantityOfProducts;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameMachine() {
		return nameMachine;
	}


	public void setNameMachine(String nameMachine) {
		this.nameMachine = nameMachine;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}


	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}


	public String getNameOfProductsFinal() {
		return nameOfProductsFinal;
	}


	public void setNameOfProductsFinal(String nameOfProductsFinal) {
		this.nameOfProductsFinal = nameOfProductsFinal;
	}


	public String getNameOfProducts() {
		return nameOfProducts;
	}


	public void setNameOfProducts(String nameOfProducts) {
		this.nameOfProducts = nameOfProducts;
	}


	public double getQuantityOfProducts() {
		return quantityOfProducts;
	}


	public void setQuantityOfProducts(double quantityOfProducts) {
		this.quantityOfProducts = quantityOfProducts;
	}
	
		@Override
		public String toString() {
			return "ConfigMachine [id=" + id + ", nameMachine=" + nameMachine + ", numberOfProducts=" + numberOfProducts 
					+ ", nameOfProductsFinal=" + nameOfProductsFinal
					+ ", nameOfProducts=" + nameOfProducts + ", quantityOfProducts=" + quantityOfProducts + "]";
		}
}
