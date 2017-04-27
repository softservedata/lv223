package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AProductListPage {

	// Fields
	
	public static final int HOME_PRODUCT_COLUMN = 3;

	public HomePage(WebDriver driver) {
		super(driver, HOME_PRODUCT_COLUMN);
	}
	
	public HomePage(WebDriver driver, int column){
		super(driver, column);
	}
	
	// PageObject

	// get Data

	// Functional

	// Business Logic

	public LoginPage gotoLoginPage() {
		clickLogin();
		return new LoginPage(driver);
	}

}
