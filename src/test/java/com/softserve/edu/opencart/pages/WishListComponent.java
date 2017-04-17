package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListComponent {

	public static final String WISH_LIST_EMPTY_MESSAGE = "Wish list is empty!";

	private static final String WISH_LIST_TABLE_SELECTOR = "table[class='table table-bordered table-hover'] ";

	private static final String COMPONENT_IMAGE_CSS_SELECTOR = WISH_LIST_TABLE_SELECTOR + "td[class='text-center'] img";
	private static final String COMPONENT_PRODUCT_NAME_CSS_SELECTOR = WISH_LIST_TABLE_SELECTOR
			+ "td[class='text-left'] a";
	private static final String COMPONENT_ADD_TO_CART_CSS_SELECTOR = "button[class='btn btn-primary']";
	private static final String COMPONENT_REMOVE_CSS_SELECTOR = WISH_LIST_TABLE_SELECTOR + ".btn.btn-danger";

	private WebElement image;
	private WebElement productName;
	private WebElement addToCart;
	private WebElement remove;
	private WebDriver driver;

	public WishListComponent(WebDriver driver, WebElement baseElement) {
		this.driver = driver;
		this.image = baseElement.findElement(By.cssSelector(COMPONENT_IMAGE_CSS_SELECTOR));
		this.productName = baseElement.findElement(By.cssSelector(COMPONENT_PRODUCT_NAME_CSS_SELECTOR));
		this.addToCart = baseElement.findElement(By.cssSelector(COMPONENT_ADD_TO_CART_CSS_SELECTOR));
		this.remove = baseElement.findElement(By.cssSelector(COMPONENT_REMOVE_CSS_SELECTOR));
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getRemove() {
		return remove;
	}

	// Get text
	public String getProductNameText() {
		return getProductName().getText();
	}

	// Click
	public void clickImage() {
		getImage().click();
	}

	public void clickProductName() {
		getProductName().click();
	}

	public void clickAddToCart() {
		getAddToCart().click();
	}

	public void clickRemove() {
		getRemove().click();
	}

	/**
	 * Return ProductPage for current product after click at image
	 */
	public ProductPage goToProductDetailsByClickImage() {
		clickImage();
		return new ProductPage(driver);
	}

	/**
	 * Return ProductPage for current product after click at product name
	 */
	public ProductPage goToProductDetailsByClickProductName() {
		clickProductName();
		return new ProductPage(driver);
	}
}
