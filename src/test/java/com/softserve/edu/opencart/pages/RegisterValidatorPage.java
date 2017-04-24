package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterValidatorPage extends RegisterPage {

	public static final String REGISTER_VALIDATOR_PAGE_EXPECTED_MESSAGE = "Warning: E-Mail Address is already registered!";
	//
	private static final String ALERT_DANGER_LABEL_CSS = ".alert.alert-danger";

	// Fields
	private WebElement alertDanger;

	public RegisterValidatorPage(WebDriver driver) {
		super(driver);
		this.alertDanger = driver.findElement(By.cssSelector(ALERT_DANGER_LABEL_CSS));
	}

	// PageObject

	// get Data

	public WebElement getAlertDangerLabel() {
		return this.alertDanger;
	}

	// Functional

	public String getAlertDangerLabelText() {
		return getAlertDangerLabel().getText();
	}

	// set Data

	// Business Logic

}
