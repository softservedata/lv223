package com.softserve.edu.opencart.data;

//TODO use builder
public class Product {

	private String details;
	private String description;
	private String price;
	private String exTaxPrice;
	
	public Product(String details, String description,
			String price, String exTaxPrice) {
		this.details = details;
		this.description = description;
		this.price = price;
		this.exTaxPrice = exTaxPrice;
	}

	public String getDetails() {
		return details;
	}

	public String getDescription() {
		return description;
	}

	public String getPrice() {
		return price;
	}

	public String getExTaxPrice() {
		return exTaxPrice;
	}

}
