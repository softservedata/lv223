package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;

public interface IProduct {
	
	String getDetails() ;

	String getDescription();

	String getPrice();

	String getExTaxPrice();

	CategoryRepository getCategory();

	String getSubCategory();
}
