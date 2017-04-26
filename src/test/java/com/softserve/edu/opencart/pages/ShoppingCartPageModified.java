package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPageModified extends ShoppingCartPage {

	public static final String SUCCESS_MODIFIED_SHOPPING_CART_MESSAGE = "Success: You have modified your shopping cart!";
	//
	private static final String MESSAGE_ABOUT_CHANGING_CART = ".alert.alert-success";

	private WebElement changeCartMessage; // ???? final?

	public ShoppingCartPageModified(WebDriver driver) {
		super(driver);
		this.changeCartMessage = driver.findElement(By.cssSelector(MESSAGE_ABOUT_CHANGING_CART));
	}

	public WebElement getChangeCartMessage() {
		return this.changeCartMessage;
	}

	public String getChangeCartMessageText() {
		return getChangeCartMessage().getText().trim();
	}

}
