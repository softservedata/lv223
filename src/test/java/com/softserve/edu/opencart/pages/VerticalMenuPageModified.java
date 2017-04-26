package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerticalMenuPageModified extends VerticalMenuPage {

	public static final String SUCCESS_ADD_SHOPPING_CART_MESSAGE = "Success: You have added %s to your shopping cart!";
	//
	private static final String MESSAGE_ADD_CART = "div.alert.alert-success";

	private WebElement addCartMessage; // ???? final?

	public VerticalMenuPageModified(WebDriver driver) {
		super(driver, MENU_PRODUCT_COLUMN);
		this.addCartMessage = driver.findElement(By.cssSelector(MESSAGE_ADD_CART));
	}

	public WebElement getAddCartMessage() {
		return this.addCartMessage;
	}

	public String getAddCartMessageText() {
		return getAddCartMessage().getText().trim();
	}

}
