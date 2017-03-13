package com.softserve.edu.opencart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.GeneralException;

public class ProductListPage extends AVerticalMenuPage {

	// Fields

	private static final String PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Product not found";
	//
	private List<ProductComponent> productsList;

	public ProductListPage(WebDriver driver, List<WebElement> elementsList) {
		super(driver);
		// TODO
	}

	// PageObject

	// get Data

	public List<ProductComponent> getProductsList() {
		return productsList;
	}

	// Functional

	public int getProductsListSize() {
		return productsList.size();
	}

	public ProductComponent getProductByIndex(int index) {
		if ((index < 0) || (index >= getProductsListSize())) {
			throw new GeneralException(PRODUCT_NOT_FOUND_ERROR_MESSAGE);
		}
		return productsList.get(index);
	}

	public ProductComponent getProductByDetailsLink(String detailsLinkText) {
		ProductComponent resultProduct = null;
		for (ProductComponent currentProduct : getProductsList()) {
			if (currentProduct.getDetailsLinkText().trim().toLowerCase()
					.equals(detailsLinkText.trim().toLowerCase())) {
				resultProduct = currentProduct;
				break;
			}
		}
		if (resultProduct == null) {
			throw new GeneralException(PRODUCT_NOT_FOUND_ERROR_MESSAGE);
		}
		return resultProduct;
	}

	// set Data

	// Business Logic

}
