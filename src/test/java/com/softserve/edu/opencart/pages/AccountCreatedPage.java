package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage extends ARightMenuRegistered {

	public static final String EXPECTED_MESSAGE = "Your Account Has Been Created!";
	//
	private static final String CONGRATULATIONS_LABEL_CSS = "#content > h1";
	private static final String CONTINUE_BUTTON_CSS = ".pull-right > a";

	// Fields
	
	private WebElement congratulations;
	private WebElement continueButton;

	protected AccountCreatedPage(WebDriver driver) {
        super(driver);
        this.congratulations = driver.findElement(By.cssSelector(CONGRATULATIONS_LABEL_CSS));
        this.continueButton = driver.findElement(By.cssSelector(CONTINUE_BUTTON_CSS));
    }

	// PageObject

    // get Data

	// Functional

	// set Data

	// Business Logic

	//gotoMyAccountPage
}
