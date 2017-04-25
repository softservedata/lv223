package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturningCustomerPage extends ARightMenuPage {

	public static final String INCORRECT_LOGIN_DATA_MESSAGE = "No match for e-mail address and/or password.";

	private WebElement email;
	private WebElement password;
	private WebElement loginButton;

	protected ReturningCustomerPage(WebDriver driver) {
		super(driver);

		this.email = driver.findElement(By.cssSelector("#input-email"));
		this.password = driver.findElement(By.cssSelector("#input-password"));
		this.loginButton = driver.findElement(By.cssSelector("input[value=\"Login\"]"));
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	// Business Logic

	/**
	 * Clicks on Login button and verify if entered correct user credentials
	 * 
	 * @return WishPage for logged user
	 */
	public WishListPage clickLoginButton() {

		getLoginButton().click();

		if (!driver.getPageSource().contains("Warning: No match for E-Mail Address and/or Password.")) {
			WishListPage wishListPage = new WishListPage(driver);
			return wishListPage;
		}
		return null;
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
