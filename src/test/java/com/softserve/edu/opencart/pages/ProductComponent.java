package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Private on package
public class ProductComponent {

	// Fields

	public static final String ATTRIBUTE_SRC = "src";
	// private static final String NAME_IMAGE = "ukraine_logo2.gif";
	//
	private WebDriver driver;
	// private WebElement baseElement;
	//
	private WebElement image;
	private WebElement detailsLink;
	private WebElement description;
	private WebElement price;
	private WebElement exTaxPrice;
	private WebElement addCart;
	private WebElement addToWishList;
	private WebElement compare;

	public ProductComponent(WebDriver driver, WebElement baseElement) {
		// public ProductComponent(WebElement baseElement) {
		this.driver = driver;
		// this.baseElement = baseElement;
		// System.out.println("+++++Base Element Text: "+baseElement.getText());
		this.image = baseElement.findElement(By.cssSelector("div[class='image'] img"));
		this.detailsLink = baseElement.findElement(By.cssSelector("div[class='caption'] a"));
		// this.description =
		// baseElement.findElement(By.xpath("//div[@class='caption']/p[1]"));
		this.description = baseElement.findElement(By.cssSelector("div[class='caption'] > p:not([class])"));
		this.price = baseElement.findElement(By.cssSelector("div[class='caption'] p[class='price']"));
		this.exTaxPrice = price.findElement(By.tagName("span"));
		//this.addCart = baseElement.findElement(By.cssSelector("div[class='button-group'] span[class='hidden-xs hidden-sm hidden-md']"));
		// Do not use XPath !
		//this.addCart = baseElement.findElement(By.xpath("//button[contains(@onclick,'cart.add')]"));
		this.addCart = baseElement.findElement(By.cssSelector("div.button-group > button:not([data-toggle])"));
		this.addToWishList = baseElement.findElement(By.cssSelector(".fa-heart"));
		this.compare = baseElement.findElement(By.cssSelector(".fa-exchange"));
		//
		// System.out.println("detailsLink = "+ detailsLink.getText());
		// System.out.println("description = "+ description.getText());
		// System.out.println("price = "+ price.getText());
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

	public WebElement getAddToWishList() {
		return addToWishList;
	}

	public WebElement getCompareButton() {
		return this.compare;
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

	public void clickAddCart() {
		getAddCart().click();
	}

	public void clickWishList() {
		getAddToWishList().click();
	}

	public void clickCompareButton() {
		getCompareButton().click();
	}

	// Business Logic

	// TODO
	public ProductPage gotoProductDetails() {
		clickDetailsLink();
		return new ProductPage(driver);
	}

	public CompareProductSpan choiceProductForCompare() {
		clickCompareButton();
		return new CompareProductSpan(driver);
	}

}
