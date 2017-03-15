package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Private on package
public class ProductComponent {

	// Fields
	
	public static final String ATTRIBUTE_SRC = "src"; 
	//private static final String NAME_IMAGE = "ukraine_logo2.gif";
	//
	private WebDriver driver;
	//private WebElement baseElement;
	//
	private WebElement image;
	private WebElement detailsLink;
	private WebElement description;
	private WebElement price;
	private WebElement exTaxPrice;
	private WebElement addCart;
	
	public ProductComponent(WebDriver driver, WebElement baseElement) {
	//public ProductComponent(WebElement baseElement) {
		this.driver = driver;
		//this.baseElement = baseElement;
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

	public WebElement getDetailsLink() {
		return this.detailsLink;
	}

	public WebElement getDescription() {
		return this.description;
	}

	public WebElement getPrice() {
		return this.price;
	}

	public WebElement getExTaxPrice() {
		return this.exTaxPrice;
	}

	public WebElement getAddCart() {
		return this.addCart;
	}

	// Functional

	public String getImageSource() {
		return getImage().getAttribute(ATTRIBUTE_SRC);
	}

	public String getDetailsLinkText() {
		return getDetailsLink().getText();
	}

	public String getDescriptionText() {
		return getDescription().getText();
	}

	public String getPriceText() {
		return getPrice().getText();
	}

	public String getExTaxPriceText() {
		return getExTaxPrice().getText();
	}

	public String getAddCartText() {
		return getAddCart().getText();
	}

	// set Data

	public void clickImage() {
		getImage().click();
	}

	public void clickDetailsLink() {
		getDetailsLink().click();
	}

	// Business Logic
	
    // TODO
	public ProductPage gotoProductDetails() {
		clickDetailsLink();
		return new ProductPage(driver);
	}

}
