package com.softserve.edu.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.GeneralException;

public class ShoppingCartPage extends AMenuPage {

	private static final String CART_LIST_RAW_SELECTOR = ".table.table-striped tr";
	public static final String CART_LIST_EMPTY_MESSAGE = "Cart list is empty!";
	private static final String CART_PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Product not found";

	private List<ShoppingCartComponent> shopingCartList;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.shopingCartList = getComponents();
	}

	// finds all raws
	public List<WebElement> getItems() {
		List<WebElement> rawList = driver.findElements(By.cssSelector(CART_LIST_RAW_SELECTOR));
		return rawList;
	}

	/**
	 * Create list of products in Cart
	 * 
	 * @return cartListComponent
	 */
	public List<ShoppingCartComponent> getComponents() {
		List<ShoppingCartComponent> shopingCartList = new ArrayList<ShoppingCartComponent>();
		for (WebElement currentProduct : getItems()) {
			ShoppingCartComponent product = new ShoppingCartComponent(driver, currentProduct);
			shopingCartList.add(product);
		}
		return shopingCartList;
	}

	/**
	 * Find size of cartList
	 * 
	 * @return number of products in Cart
	 */
	public int getCartListSize() {
		return shopingCartList.size();
	}

	/**
	 * Find element of wish list by index
	 * 
	 * @param index
	 *            number of element in list
	 * 
	 * @return element of wish list
	 */
	public ShoppingCartComponent getCartComponentByIndex(int index) {
		if ((index < 0) || (index >= getCartListSize())) {
			throw new GeneralException(CART_LIST_EMPTY_MESSAGE);
		}
		return shopingCartList.get(index);
	}

	/**
	 * Find element of cart list by product name
	 * 
	 * @param name
	 *            name of searched element
	 * 
	 * @return element of Cart list
	 */
	public ShoppingCartComponent getCartComponentByName(String name) {
		ShoppingCartComponent resultCartProduct = null;

		for (ShoppingCartComponent currentProduct : shopingCartList) {
			if (currentProduct.getProductNameText().trim().toLowerCase().equals(name.trim().toLowerCase())) {
				resultCartProduct = currentProduct;
				break;
			}
		}

		if (resultCartProduct == null) {
			throw new GeneralException(CART_PRODUCT_NOT_FOUND_ERROR_MESSAGE);
		}
		return resultCartProduct;
	}

	/**
	 * Checks if Cart list contains component with specified name
	 * 
	 * @param productName
	 *            the product name of the component
	 * @return true if component exist in the Cart list
	 */
	public boolean isProductPresentInCartList(String productName) {
		boolean isPresent = false;
		for (ShoppingCartComponent currentProduct : shopingCartList) {
			if (currentProduct.getProductNameText().trim().toLowerCase().equals(productName.trim().toLowerCase())) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}

}