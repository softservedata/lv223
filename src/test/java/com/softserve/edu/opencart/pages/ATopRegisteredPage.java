package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.GeneralException;

public abstract class ATopRegisteredPage extends ARightMenuPage {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	protected class MyAccountATopRegisteredPage extends MyAccountATopPage {
		public static final String LOGOUT_MESSAGE = "Must be Logout";
		private WebElement myAccount;
		private WebElement logout;

		public MyAccountATopRegisteredPage() {
			this.myAccount = driver.findElement(By.linkText("My Account"));
			this.logout = driver.findElement(By.linkText("Logout"));
		}

		@Override
		public WebElement getATopRegister() {
			throw new GeneralException(LOGOUT_MESSAGE);
			// return null;
		}

		@Override
		public WebElement getATopLogin() {
			throw new GeneralException(LOGOUT_MESSAGE);
			// return null;
		}

		public WebElement getATopMyAccount() {
			return this.myAccount;
		}

		public WebElement getATopLogout() {
			return this.logout;
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public ATopRegisteredPage(WebDriver driver) {
		super(driver);
	}

	// PageObject

	// get Data

	@Override
	public WebElement getRegister() {
		// try {
		// return super.getRegister();
		// } catch (GeneralException e) {
		// clickLogout();
		// }
		clickLogout();
		return super.getRegister();
	}

	@Override
	public WebElement getLogin() {
		clickLogout();
		return super.getLogin();
	}

	public WebElement getSubMyAccount() {
		clickMyAccount();
		// return this.myAccountATopPage.register;
		return ((MyAccountATopRegisteredPage) this.myAccountATopPage).getATopMyAccount();
	}

	public WebElement getLogout() {
		clickMyAccount();
		// return this.myAccountATopPage.register;
		return ((MyAccountATopRegisteredPage) this.myAccountATopPage).getATopLogout();
	}

	// Functional

	// set Data

	@Override
	public void clickMyAccount() {
		// clickPhone();
		clickSearchInput();
		getMyAccount().click();
		// myAccountATopPage = new MyAccountATopPage();
		myAccountATopPage = new MyAccountATopRegisteredPage();
	}

	public void clickSubMyAccount() {
		getSubMyAccount().click();
	}

	public void clickLogout() {
		getLogout().click();
	}

	// Business Logic

	public MyAccountPage gotoSubMyAccountPage() {
		clickLogout();
		return new MyAccountPage(driver);
	}

	public LogoutPage gotoSubLogoutPage() {
		clickLogout();
		return new LogoutPage(driver);
	}

}
