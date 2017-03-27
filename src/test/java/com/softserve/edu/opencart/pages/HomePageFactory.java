package com.softserve.edu.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	// Fields
	//
	public static final String VALUE_ATTRIBUTE = "value";
	//
	private WebDriver driver;
	//
	@FindBy(xpath = "//div[@id='top-links']//a[contains(@href, '/contact')]")
	private WebElement contact;
	//
	//@CacheLookup
	@FindBy(css = "input.form-control.input-lg")
	private WebElement searchInput;
	//
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // 1st item
	}

	// PageObject

	// get Data

	public WebElement getContact() {
		return this.contact;
	}

	public WebElement getSearchInput() {
		return this.searchInput;
	}

	public WebElement getSearchButton() {
		return this.searchButton;
	}

	public boolean isWebElementPresentByPartialLinkText(String partialLinkText) {
		List<WebElement> itesm = driver.findElements(By.partialLinkText(partialLinkText));
		return (itesm.size() > 0) && (itesm.get(0).isDisplayed()) && (itesm.get(0).isEnabled());
	}

	// Functional

	public String getContactText() {
		return getContact().getText();
	}

	public String getSearchInputText() {
		return getSearchInput().getAttribute(VALUE_ATTRIBUTE);
	}

	// set Data

	public void clearSearchInput() {
		getSearchInput().clear();
	}

	public void clickSearchButton() {
		getSearchButton().click();
	}

	public void sendKeysSearchInput(String text) {
		getSearchInput().sendKeys(text);
	}

	// Business Logic

	public HomePageFactory gotoSearchItem(String text) {
		clearSearchInput();
		sendKeysSearchInput(text);
		clickSearchButton();
		return new HomePageFactory(driver);
	}

}
