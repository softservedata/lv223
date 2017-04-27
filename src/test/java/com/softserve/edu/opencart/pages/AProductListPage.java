package com.softserve.edu.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.GeneralException;

abstract class AProductListPage extends AMenuPage {

	// Fields

	protected static final String PRODUCT_LIST_CSSSELECTOR = "div.product-layout.product-grid.col-lg-%d.col-md-%d.col-sm-6.col-xs-12";
	//
	private static final String PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Product not found";
	//
	private List<ProductComponent> productsList;

	public AProductListPage(WebDriver driver, int column) {
		super(driver);
		this.productsList = getProductItems(column);
	}

	// PageObject

	private List<ProductComponent> getProductItems(int column) {
		List<ProductComponent> productComponents = new ArrayList<ProductComponent>();
		for (WebElement currentElement : getListItems(column)) {
			ProductComponent product = new ProductComponent(driver, currentElement);
			productComponents.add(product);
		}
		return productComponents;
	}
	
	private List<WebElement> getListItems(int column) {
		return driver.findElements(By.cssSelector(String
				.format(PRODUCT_LIST_CSSSELECTOR, column, column)));
	}

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
		//System.out.println("+++++getProductByDetailsLink(String detailsLinkText) = " + detailsLinkText);
		ProductComponent resultProduct = null;
		for (ProductComponent currentProduct : getProductsList()) {
			//System.out.println("+++currentProduct.getDetailsLinkText() = "
			//		+ currentProduct.getDetailsLinkText());
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
