package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends AMenuPage {

	// Fields
	
	private WebElement description;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.description = driver.findElement(By.cssSelector("a[href='#tab-description']"));
	}

	// PageObject

	// get Data

	public WebElement getDescription() {
		return this.description;
	}

	// Functional

	public String getDescriptionText() {
		return getDescription().getText();
	}

	// set Data

	public void clickDescription() {
		getDescription().click();
	}

	// Business Logic

}
