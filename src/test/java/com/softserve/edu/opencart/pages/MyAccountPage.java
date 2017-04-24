package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 30.03.2017.
 */
public class MyAccountPage extends ARightMenuRegistered {

	public static final String MY_ACCOUNT_PAGE_EXPECTED_MESSAGE = "My Account";
	//
	private static final String MY_ACCOUNT_LABEL_XPATH = "//h2[contains(text(),'My Account')]";
	
	// Fields
	private WebElement myAccount;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.myAccount = driver.findElement(By.xpath(MY_ACCOUNT_LABEL_XPATH));
    }

	// PageObject

    // get Data

	public WebElement getMyAccountLabel() {
		return this.myAccount;
	}

	// Functional
	
	public String getMyAccountLabelText() {
		return getMyAccountLabel().getText();
	}
	
	// set Data
	
	// Business Logic

}
