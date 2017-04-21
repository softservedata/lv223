package com.softserve.edu.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.ProductDataUtils;
import com.softserve.edu.opencart.tools.GeneralException;

/**
 * Created by Anna Orlovska on 30.03.2017.
 */
public class WishListPage extends ARightMenuPage {

	private static final String WISH_LIST_RAW_SELECTOR = "table[class='table table-bordered table-hover'] tbody tr";
	private static final String WISH_PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Product not found";

	private List<WishListComponent> wishComponentList;

	protected WishListPage(WebDriver driver) {
		super(driver);
		this.wishComponentList = getComponents();
	}

	public List<WishListComponent> getWishComponentList() {
		return wishComponentList;
	}

	private List<WebElement> getItems() {
		List<WebElement> list = driver.findElements(By.cssSelector(WISH_LIST_RAW_SELECTOR)); 
		return list;
	}

	/**
	 * Create list of wished products
	 * 
	 * @return wishListComponent
	 */
	public List<WishListComponent> getComponents() {
		List<WishListComponent> wishListComponents = new ArrayList<WishListComponent>();
		for (WebElement currentElement : getItems()) {
			WishListComponent product = new WishListComponent(driver, currentElement);
			wishListComponents.add(product);
		}
		return wishListComponents;
	}

/**
 * Find size of WishList
 * 
 * @return number of wished products
 */
	public int getWishListSize() {
		return wishComponentList.size();
	}

	/**
	 * Find element of wish list by index
	 * 
	 * @param index
	 * 		number of element in list
	 * 
	 * @return element of wish list
	 */
	public WishListComponent getWishComponentByIndex(int index) {
		if ((index < 0) || (index >= getWishListSize())) {
			throw new GeneralException(WISH_PRODUCT_NOT_FOUND_ERROR_MESSAGE);
		}
		return wishComponentList.get(index);
	}

	/**
	 * Find element of wish list by product name
	 * 
	 * @param productName
	 * 		name of searched element
	 * 
	 * @return element of wish list
	 */
	public WishListComponent getWishListComponentByProductName(String productName) {

		WishListComponent resultWishProduct = null;

		for (WishListComponent currentProduct : getComponents()) {
			if (currentProduct.getProductNameText().trim().toLowerCase().equals(productName.trim().toLowerCase())) {
				resultWishProduct = currentProduct;
				break;
			}
		}

		if (resultWishProduct == null) {
			throw new GeneralException(WISH_PRODUCT_NOT_FOUND_ERROR_MESSAGE);
		}
		return resultWishProduct;
	}
	

	/**
	 * Checks if wish list contains component with specified name
	 * 
	 * @param productName
	 *            the product name of the component
	 * @return true if component exist in the wish list
	 */
	public boolean isComponentExistInWishList(String productName) {

		boolean condition = false;
		for (WishListComponent component : getComponents()) {
			if (component.getProductNameText().equals(productName)) {
				condition = true;
				break;
			}
		}
		return condition;
	}

	@Override
	public ARightMenuPage gotoMyAccountPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoAddressBookPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoWishListPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoOrderHistoryPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoDownloadsPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoRecurringPaymentsPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoRewardPointsPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoReturns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ARightMenuPage gotoNewsletter() {
		// TODO Auto-generated method stub
		return null;
	}
}
