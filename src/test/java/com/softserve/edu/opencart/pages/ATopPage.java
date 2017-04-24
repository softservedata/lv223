package com.softserve.edu.opencart.pages;

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
		public final WebElement euro;
		public final WebElement pound;
		public final WebElement dollar;

		public CurencyATopPage() {
    		this.euro = driver.findElement(By.name("EUR"));
    		this.pound = driver.findElement(By.name("GBP"));
    		this.dollar = driver.findElement(By.name("USD"));
    	}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	protected class MyAccountATopPage {
		private WebElement register;
		private WebElement login;

		public MyAccountATopPage() {
    		this.register = driver.findElement(By.xpath("//a[contains(@href, 'account/register')]"));
    		this.login = driver.findElement(By.xpath("//a[contains(@href, 'account/login')]"));
    	}
		
		public WebElement getATopRegister() {
			return this.register;
		}

		public WebElement getATopLogin() {
			return this.login;
		}
}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields

	public static final String ATTRIBUTE_VALUE = "value";
	private static final String VISIBLE_ERROR_MESSAGE = "Element not visible";
	//
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	//
	protected WebDriver driver;
	//
	private WebElement currency;
	private CurencyATopPage curencyATopPage;
	//private WebElement phone;
	private List<WebElement> phones;
	private WebElement contact;
	private WebElement myAccount;
	protected MyAccountATopPage myAccountATopPage;
	private WebElement logoImage;
	private WebElement searchInput;
	private Compare compare;

	//===============================================

	private LoginPage loginPage;

	//===============================================

	protected ATopPage(WebDriver driver) {
		this.driver = driver;
		this.currency = driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle"));
		//this.phone = driver.findElement(By.cssSelector("li > span.hidden-xs.hidden-sm.hidden-md"));
		this.contact = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href, '/contact')]"));
		//this.myAccount = driver.findElement(By.cssSelector("a.dropdown-toggle > span.hidden-xs.hidden-sm.hidden-md"));
		this.myAccount = driver.findElement(By.cssSelector("i.fa.fa-user"));
		this.logoImage = driver.findElement(By.cssSelector("img[alt='Your Store']"));
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
//		System.out.println("isPhone() start");
		phones = driver.findElements(By.cssSelector("li > span.hidden-xs.hidden-sm.hidden-md")); 
//		System.out.println("isPhone() done, phones.size() = " + phones.size() 
//			+ " isDisplayed= " + phones.get(0).isDisplayed() 
//			+ " isEnabled= " + phones.get(0).isEnabled() );
		return (phones.size() > 0) && (phones.get(0).isDisplayed()) && (phones.get(0).isEnabled());
	}

	public WebElement getPhone() {
		if (!isPhone()) {
			throw new GeneralException(VISIBLE_ERROR_MESSAGE);
		}
		//return this.phone;
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
		return this.myAccountATopPage.getATopRegister();
	}

	public WebElement getLogin() {
		clickMyAccount();
		return this.myAccountATopPage.getATopLogin();
	}

	public WebElement getLogoImage() {
		return this.logoImage;
	}

	public WebElement getSearchInput() {
		return this.searchInput;
	}
	
	// Functional

	public String getDollarText(){
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

	public String getSearchInputText() {
		return getSearchInput().getAttribute(ATTRIBUTE_VALUE);
	}

	// set Data

	
	
	public void clickCurrency() {
		//clickPhone();
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
		//clickPhone();
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

	public void clickLogoImage() {
		getLogoImage().click();
	}
	
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

	public LoginPage gotoLoginPage(){
		clickLogin();
		return new LoginPage(driver);
	}

	public RegisterPage gotoRegisterPage(){
		clickRegister();
		return new RegisterPage(driver);
	}

	public HomePage gotoLogoHomePage(){
		clickLogoImage();
		return new HomePage(driver);
	}

	//////////////////////////////////////////////////////////////////////
}
