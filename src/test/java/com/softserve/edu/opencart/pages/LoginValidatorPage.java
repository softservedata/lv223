package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage extends LoginPage {

	// Fields

	private static final String VALIDATOR_ERROR_CSS_SELECTOR = ".alert.alert-danger";
	//
	private WebElement validatorError;
	
	public LoginValidatorPage(WebDriver driver) {
		super(driver);
		this.validatorError = driver.findElement(By.cssSelector(VALIDATOR_ERROR_CSS_SELECTOR));
	}

	// PageObject

	// get Data

	public WebElement getValidatorError() {
		return this.validatorError;
	}

	// Functional

	public String getValidatorErrorText() {
		return getValidatorError().getText();
	}

	// set Data

	// Business Logic

}
