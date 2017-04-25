package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartComponent {

	// Fields

	public static final String CART_LIST_TABLE_SELECTOR = ".table.table-bordered ";

	private static final String PRODUCT_IMAGE_CSS = ".text-center > a";
	private static final String PRODUCT_NAME_CSS = ".text-left > a";
	private static final String PRODUCT_QUANTITY_CSS = ".input-group.btn-block > input";
	private static final String PRODUCT_UPDATE_CSS = ".input-group.btn-block .btn.btn-primary";
	private static final String PRODUCT_REMOVE_CSS = ".input-group.btn-block .btn.btn-danger";

	//
	private WebDriver driver;
	//
	private WebElement productImage;
	private WebElement productName;
	private WebElement productQuantity;
	private WebElement productUpdate;
	private WebElement productRemove;

	public ShoppingCartComponent(WebDriver driver, WebElement baseElement) {
		this.driver = driver;
		this.productImage = baseElement.findElement(By.cssSelector(PRODUCT_IMAGE_CSS));
		this.productName = baseElement.findElement(By.cssSelector(PRODUCT_NAME_CSS));
		this.productQuantity = baseElement.findElement(By.cssSelector(PRODUCT_QUANTITY_CSS));
		this.productUpdate = baseElement.findElement(By.cssSelector(PRODUCT_UPDATE_CSS));
		this.productRemove = baseElement.findElement(By.cssSelector(PRODUCT_REMOVE_CSS));
	}

	// PageObject

	// get Data

	public WebElement getProductImage() {
		return productImage;
	}

	public ProductPage clickProductImage() {			//????? 
		getProductImage().click();
		return new ProductPage(driver);
	}
	
	public WebElement getProductName() {
		return productName;
	}
	
	public String getProductNameText() {
		return getProductName().getText();
	}

	public ProductPage clickProductName() {
		getProductName().click();
		return new ProductPage(driver);
	}
	
	public WebElement getProductQuantity() {
		return productQuantity;
	}
	
	public String getProductQuantityText() {
		return getProductQuantity().getText();
	}

	public void setQuantity(String quantity) {
		getProductQuantity().sendKeys(quantity);
	}
	
	public WebElement getProductUpdate() {
		return productUpdate;
	}
	
	public void clickUpdate() {
		getProductUpdate().click();
	}

	public WebElement getProductRemove() {
		return productRemove;
	}

	public void clickRemove() {
		getProductRemove().click();
	}
	// Functional

	// set Data

	// Business Logic

}