package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends AMenuPage {

	// Fields
	
	private WebElement description;
	private WebElement compare;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.description = driver.findElement(By.cssSelector("a[href='#tab-description']"));
		this.compare = driver.findElement(By.cssSelector(".fa-exchange")); 
	}

	// PageObject

	// get Data

	public WebElement getDescription() {
		return this.description;
	}
	
	public WebElement getCompareButton(){
		return this.compare;
	}

	// Functional

	public String getDescriptionText() {
		return getDescription().getText();
	}

	// set Data

	public void clickDescription() {
		getDescription().click();
	}
	public void clickCompareButton(){
		getCompareButton().click();
	}

	// Business Logic
	
	public CompareProductSpan choiceProductForCompare() {
		clickCompareButton();
		return new CompareProductSpan(driver);
	}

}
