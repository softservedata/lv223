package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 30.03.2017.
 */
public class EditAccountPage extends ARightMenuRegistered {

	private static final String VALUE_ATTRIBUTE = "value";
	//
	private static final String EMAIL_INPUT_ID = "input-email";
	
	// Fields
	private WebElement email;

	public EditAccountPage(WebDriver driver) {
        super(driver);
        this.email = driver.findElement(By.id(EMAIL_INPUT_ID));
    }
	
	// PageObject

    // get Data

	public WebElement getEmailInput() {
		return this.email;
	}

	// Functional
	
	public String getEmailInputValue() {
		//return getEmailInput().getText(); // Error
		return getEmailInput().getAttribute(VALUE_ATTRIBUTE);
	}
	
	// set Data
	
	public void clearEmailInput() {
		getEmailInput().clear();
	}

	public void clickEmailInput() {
		getEmailInput().click();
	}

	// Business Logic

}
