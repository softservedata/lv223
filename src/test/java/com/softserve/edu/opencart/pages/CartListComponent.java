package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartListComponent {
	
	//public static final String CART_LIST_TABLE_SELECTOR = "table[class='table table-striped'] ";	
	public static final String CART_LIST_TABLE_SELECTOR = ".table.table-striped ";
	
	private static final String CART_PRODUCT_IMAGE_SELECTOR =CART_LIST_TABLE_SELECTOR+".text-center img";
//	private static final String CART_PRODUCT_IMAGE_SELECTOR =CART_LIST_TABLE_SELECTOR+"td[class='text-center'] img";
	private static final String CART_PRODUCT_NAME_SELECTOR =CART_LIST_TABLE_SELECTOR+".text-left a";
//	private static final String CART_PRODUCT_NAME_SELECTOR =CART_LIST_TABLE_SELECTOR+"td[class='text-left'] a";
	private static final String CART_PRODUCT_REMOVE_SELECTOR =CART_LIST_TABLE_SELECTOR+".btn.btn-danger";
	
	private WebDriver driver;
	private WebElement productImage;
	private WebElement productName;
	private WebElement deleteButton;
	
	
	public CartListComponent(WebDriver driver, WebElement baseElement) {
		this.driver=driver;
		this.productImage=baseElement.findElement(By.cssSelector(CART_PRODUCT_IMAGE_SELECTOR));	//??? різні cssSelector
		this.productName= baseElement.findElement(By.cssSelector(CART_PRODUCT_NAME_SELECTOR));
		this.deleteButton= baseElement.findElement(By.cssSelector(CART_PRODUCT_REMOVE_SELECTOR));
	}
	
	public WebElement getProductImage(){
		return productImage;
	}
	
	public ProductPage clickProductImage() {			//????? Чи має повертатися сторінка продукту
		getProductImage().click();
		return new ProductPage(driver);
	}
	
	public WebElement getProductName(){
		return productName;
	}
	
	public String getProductNameText() {
		return getProductName().getText();	
	}
	
	public ProductPage clickProductName() {
		getProductName().click();
		return new ProductPage(driver);
	}
	
	public WebElement getDeleteButton(){
		return deleteButton;
	}
	
	public void clickDeleteButton() {
		getDeleteButton().click();
	}
	
}
