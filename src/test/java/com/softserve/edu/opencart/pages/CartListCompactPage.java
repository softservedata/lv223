package com.softserve.edu.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartListCompactPage {	// ??? �� �� ���� ����������

	private static final String CART_LIST_RAW_SELECTOR = ".table.table-striped tbody tr";
	public static final String CART_LIST_EMPTY_MESSAGE = "Cart list is empty!";
	private static final String CART_PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Product not found";
	
	private List<CartListComponent> cartListComponent;
	
	public CartListCompactPage(WebDriver driver) {
		//TODO getComponents() must be implemented.
		//this.cartListComponent = getComponents();
	}
	
	public List<CartListComponent> getCartComponents(){
		return cartListComponent;
	}
	
	
//	public List<WebElement> getItems() {
//		//		List<WebElement> list = driver.findElements(By.cssSelector(WISH_LIST_RAW_SELECTOR)); 
//				return list;
//	}
	
}