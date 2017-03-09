package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Private on package
class ProductComponent {

	// Fields
	
	//private WebDriver driver;
	private WebElement baseElement;
	//
	private WebElement image;
	private WebElement detailsLink;
	private WebElement description;
	private WebElement price;
	private WebElement exTaxPrice;
	private WebElement addCart;
	
	//public ProductComponent(WebDriver driver, WebElement base) {
	public ProductComponent(WebElement baseElement) {
		//this.driver = driver;
		this.baseElement = baseElement;
		this.image = baseElement.findElement(By.cssSelector("div[class='image'] img"));
		this.detailsLink = baseElement.findElement(By.cssSelector("div[class='caption'] a"));
		this.description = baseElement.findElement(By.xpath("//div[@class='caption']/p[1]"));
		this.price = baseElement.findElement(By.cssSelector("div[class='caption'] p[class='price']"));
		this.exTaxPrice = price.findElement(By.tagName("span"));
		this.addCart = baseElement.findElement(By.cssSelector("div[class='button-group'] span[class='hidden-xs hidden-sm hidden-md']"));
	}
	
	// PageObject

	// get Data

	public WebElement getImage() {
		return this.image;
	}

	// Functional

	// set Data

	// Business Logic

}
