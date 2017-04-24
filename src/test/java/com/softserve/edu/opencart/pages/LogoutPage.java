package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 30.03.2017.
 */
public class LogoutPage extends ARightMenuUnregister {

	public static final String LOGOUT_PAGE_EXPECTED_MESSAGE = "Account Logout";
	//
	private static final String ACCOUNT_LOGOUT_LABEL_XPATH = "//h1[contains(text(),'Account Logout')]";
	private static final String LOGOUT_CONTINUE_BUTTON_LINKTEXT = "Continue";
	
	// Fields
	private WebElement accountLogout;
	private WebElement logoutContinue;

	public LogoutPage(WebDriver driver) {
        super(driver);
        this.accountLogout = driver.findElement(By.xpath(ACCOUNT_LOGOUT_LABEL_XPATH));
        this.logoutContinue = driver.findElement(By.linkText(LOGOUT_CONTINUE_BUTTON_LINKTEXT));
    }
	
	// PageObject

    // get Data

	public WebElement getAccountLogoutLabel() {
		return this.accountLogout;
	}

	public WebElement getLogoutContinueButton() {
		return this.logoutContinue;
	}

	// Functional
	
	public String getAccountLogoutLabelText() {
		return getAccountLogoutLabel().getText();
	}

	public String getLogoutContinueButtonText() {
		return getLogoutContinueButton().getText();
	}

	// set Data
	
	public void clickLogoutContinueButton() {
		 getLogoutContinueButton().click();
	}

	// Business Logic

	public HomePage gotoContinueHomePage() {
		clickLogoutContinueButton();
		return new HomePage(driver);
	}

}
