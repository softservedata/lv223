package com.softserve.edu.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.opencart.tools.GeneralException;

abstract class ATopPage {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	private class Compare {

	}

	private class CurencyATopPage {
		public final WebElement euro;		//????????? public?
		public final WebElement pound;
		public final WebElement dollar;

		public CurencyATopPage() {
			this.euro = driver.findElement(By.name("EUR"));
			this.pound = driver.findElement(By.name("GBP"));
			this.dollar = driver.findElement(By.name("USD"));
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class MyAccountATopPage {
		public final WebElement register;
		public final WebElement login;

		public MyAccountATopPage() {
			this.register = driver.findElement(By.xpath("//a[contains(@href, 'account/register')]"));
			this.login = driver.findElement(By.xpath("//a[contains(@href, 'account/login')]"));
		}
	}

	// - - - - - - - - - - - CartListCompactPage- - - - - - - - - - - - - - - -
	// - - -

	public class CartListCompactPage { // ????? Public or private
		//
		private static final String CART_LIST_RAW_SELECTOR = ".table.table-striped tbody tr";
		public static final String CART_LIST_EMPTY_MESSAGE = "Cart list is empty!";
		private static final String CART_PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Product not found";

		private List<CartListComponent> cartComponentList;

		public CartListCompactPage() {
			this.cartComponentList = getComponents();
		}

		// public List<CartListComponent> getCartComponents(){
		// return cartComponentList;
		// }

		// finds all raws
		public List<WebElement> getItems() {
			//List<WebElement> rawList = driver.findElements(By.cssSelector(CART_LIST_RAW_SELECTOR));
			//return rawList;
			return driver.findElements(By.cssSelector(CART_LIST_RAW_SELECTOR));
		}

		/**
		 * Create list of products in Cart
		 * 
		 * @return cartListComponent
		 */
		public List<CartListComponent> getComponents() {
			List<CartListComponent> cartList = new ArrayList<CartListComponent>();
			// Cycle for all tags <tr>
			for (WebElement currentProduct : getItems()) {
				CartListComponent product = new CartListComponent(driver, currentProduct);
				cartList.add(product);
			}
			return cartList;
		}

		/**
		 * Find size of cartList
		 * 
		 * @return number of products in Cart
		 */
		public int getCartListSize() {
			return cartComponentList.size();
		}

		/**
		 * Find element of wish list by index
		 * 
		 * @param index
		 *            number of element in list
		 * 
		 * @return element of wish list
		 */
		public CartListComponent getCartComponentByIndex(int index) {
			if ((index < 0) || (index >= getCartListSize())) {
				throw new GeneralException(CART_LIST_EMPTY_MESSAGE);
			}
			return cartComponentList.get(index);
		}

		/**
		 * Find element of cart list by product name
		 * 
		 * @param name
		 *            name of searched element
		 * 
		 * @return element of Cart list
		 */
		public CartListComponent getCartComponentByName(String name) {
			CartListComponent resultCartProduct = null;
			for (CartListComponent currentProduct : cartComponentList) {
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
			for (CartListComponent currentProduct : cartComponentList) {
				if (currentProduct.getProductNameText().trim().toLowerCase().equals(productName.trim().toLowerCase())) {
					isPresent = true;
					break;
				}
			}
			return isPresent;
		}

	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields

	public static final String ATTRIBUTE_VALUE = "value";
	protected static final String VISIBLE_ERROR_MESSAGE = "Element not visible";
	//
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	//
	protected WebDriver driver;
	//
	private WebElement currency;
	private CurencyATopPage curencyATopPage;
	// private WebElement phone;
	private List<WebElement> phones;
	private WebElement contact;
	private WebElement myAccount;
	private MyAccountATopPage myAccountATopPage;
	private WebElement wishListTop;

	private WebElement shoppingCart;
	private WebElement shoppingCartButton;

	private WebElement searchInput;
	private Compare compare;

	// ===============================================

	private LoginPage loginPage;

	private CartListCompactPage cartListCompactPage; // ???

	// ===============================================

	protected ATopPage(WebDriver driver) {
		this.driver = driver;
		this.currency = driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle"));
		// this.phone = driver.findElement(By.cssSelector("li >
		// span.hidden-xs.hidden-sm.hidden-md"));
		this.contact = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href, '/contact')]"));
		// this.myAccount = driver.findElement(By.cssSelector("a.dropdown-toggle
		// > span.hidden-xs.hidden-sm.hidden-md"));
		this.wishListTop = driver.findElement(By.cssSelector("#wishlist-total span"));
		this.myAccount = driver.findElement(By.cssSelector("i.fa.fa-user"));
		//this.shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart'] span"));
		this.shoppingCart = driver.findElement(By.xpath("//li/a[contains(@href,'route=checkout/cart')]"));
		this.shoppingCartButton = driver.findElement(By.cssSelector("#cart button"));
		this.searchInput = driver.findElement(By.cssSelector("input.form-control.input-lg"));
	}

	// PageObject

	// get Data

	public WebElement getCurrency() {
		return this.currency;
	}

	public WebElement getEuro() {
		clickCurrency();
		return this.curencyATopPage.euro;
	}

	public WebElement getPound() {
		clickCurrency();
		return this.curencyATopPage.pound;
	}

	public WebElement getDollar() {
		clickCurrency();
		return this.curencyATopPage.dollar;
	}

	public boolean isPhone() {
		// System.out.println("isPhone() start");
		phones = driver.findElements(By.cssSelector("li > span.hidden-xs.hidden-sm.hidden-md"));
		// System.out.println("isPhone() done, phones.size() = " + phones.size()
		// + " isDisplayed= " + phones.get(0).isDisplayed()
		// + " isEnabled= " + phones.get(0).isEnabled() );
		return (phones.size() > 0) && (phones.get(0).isDisplayed()) && (phones.get(0).isEnabled());
	}

	public WebElement getPhone() {
		if (!isPhone()) {
			throw new GeneralException(VISIBLE_ERROR_MESSAGE);
		}
		// return this.phone;
		return phones.get(0);
	}

	public WebElement getContact() {
		return this.contact;
	}

	public WebElement getMyAccount() {
		return this.myAccount;
	}

	public WebElement getRegister() {
		clickMyAccount();
		return this.myAccountATopPage.register;
	}

	public WebElement getLogin() {
		clickMyAccount();
		return this.myAccountATopPage.login;
	}

	public WebElement getWishListTop() {
		return this.wishListTop;
	}

	public WebElement getShoppingCart() {
		return this.shoppingCart;
	}

	public WebElement getShoppingCartButton() {
		return this.shoppingCartButton;
	}

	public WebElement getSearchInput() {
		return this.searchInput;
	}

	public CartListCompactPage getCartListCompactPage() {
		clickShoppingCartButton();
		return this.cartListCompactPage;
	}

	// Functional

	public String getDollarText() {
		return curencyATopPage.dollar.getText();
	}

	public String getCurrencyText() {
		return getCurrency().getText();
	}

	public String getPhoneText() {
		return getPhone().getText();
	}

	public String getMyAccountText() {
		return getMyAccount().getText();
	}

	public String getWishListTopText() {
		return getWishListTop().getText();

	}

	public String getShoppingCartButtonText() {
		return getShoppingCartButton().getText();
	}

	public String getSearchInputText() {
		return getSearchInput().getAttribute(ATTRIBUTE_VALUE);
	}

	// set Data

	public void clickCurrency() {
		// clickPhone();
		clickSearchInput();
		getCurrency().click();
		curencyATopPage = new CurencyATopPage();
	}

	public void clickPhone() {
		getPhone().click();
	}

	public void clickEuro() {
		getEuro().click();
	}

	public void clickPound() {
		getPound().click();
	}

	public void clickDollar() {
		getDollar().click();
	}

	public void clickContact() {
		getContact().click();
	}

	public void clickMyAccount() {
		// clickPhone();
		clickSearchInput();
		getMyAccount().click();
		myAccountATopPage = new MyAccountATopPage();
	}

	public void clickRegister() {
		getRegister().click();
	}

	public void clickLogin() {
		getLogin().click();
	}

	public void clickWishListTop() {
		getWishListTop().click(); // ?????
	}
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void clickShoppingCart() {
		getShoppingCart().click();
	}
	
	public void clickShoppingCartButton() {
		getShoppingCartButton().click();
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void clearSearchInput() {
		getSearchInput().clear();
	}

	public void clickSearchInput() {
		getSearchInput().click();
	}

	public void sendKeysSearchInput(String text) {
		getSearchInput().sendKeys(text);
	}

	// Business Logic

	public LoginPage gotoLoginPage() {
		clickLogin();
		return new LoginPage(driver);
	}

	public ARightMenuPage gotoWishListPageTop() {
		clickWishListTop();
		return new ReturningCustomerPage(driver);
	}

	public ShoppingCartPage gotoShoppingCart() {
		clickShoppingCart();
		return new ShoppingCartPage(driver);
	}
	
	public CartListCompactPage openShoppingCartButton() {
		getShoppingCartButton().click();
		return cartListCompactPage = new CartListCompactPage();
	}

	public ProductPage gotoProductPageByName(String productName) {
		// TODO Use getter for cartListCompactPage 
		getCartListCompactPage().getCartComponentByName(productName).clickProductName();
		//cartListCompactPage = null;
		return new ProductPage(driver);
	}

	public ATopPage deleteProductFromCartByName(String productName) {
		// TODO Use getter for cartListCompactPage 
		getCartListCompactPage().getCartComponentByName(productName).clickDeleteButton();
		//cartListCompactPage = null;
		return this;
	}

	//////////////////////////////////////////////////////////////////////
}
