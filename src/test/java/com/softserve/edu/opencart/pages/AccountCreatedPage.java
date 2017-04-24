package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;

public class AccountCreatedPage extends ARightMenuRegistered {

	public static final String ACCOUNT_CREATED_PAGE_EXPECTED_MESSAGE = "Your Account Has Been Created!";
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

	public WebElement getCongratulationsLabel() {
		return this.congratulations;
	}

	public WebElement getContinueButton() {
		return this.continueButton;
	}

	// Functional

	public String getCongratulationsLabelText() {
		return getCongratulationsLabel().getText();
	}

	// set Data

	public void clickContinueButton() {
		 getContinueButton().click();
	}
	
	// Business Logic

	public MyAccountPage gotoMyAccountPage() {
		clickContinueButton();
		return new MyAccountPage(driver);
	}

}
