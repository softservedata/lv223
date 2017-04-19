package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.data.IUser;

/**
 * Created by FPF on 30.03.2017.
 */
public class RegisterPage extends ARightMenuUnregister {

	private static final String FIRSTNAME_INPUT_ID = "input-firstname";
	private static final String LASTNAME_INPUT_ID = "input-lastname";
	private static final String EMAIL_INPUT_ID = "input-email";
	private static final String TELEPHONE_INPUT_ID = "input-telephone";
	private static final String ADDRESS_INPUT_ID = "input-address-1";
	private static final String CITY_INPUT_ID = "input-city";
	private static final String POSTCODE_INPUT_ID = "input-postcode";
	private static final String COUNTRY_SELECT_ID = "input-country";
	private static final String REGION_SELECT_ID = "input-zone";
	private static final String PASSWORD_INPUT_ID = "input-password";
	private static final String PASSWORDCONFIRM_INPUT_ID = "input-confirm";
	private static final String PRIVACYPOLICY_CHECKBOX_CSS = "input[type='checkbox']";
	private static final String CONTINUE_BUTTON_CSS = "input[type='submit']";


	// Fields
	private WebElement firstname;
	private WebElement lastname;
	private WebElement email;
	private WebElement telephone;
	private WebElement address;
	private WebElement city;
	private WebElement postCode;
	private Select country;
	private Select region;
	private WebElement password;
	private WebElement passwordConfirm;
	private WebElement privacyPolicy;
	private WebElement continueButton;

    protected RegisterPage(WebDriver driver) {
        super(driver);
        this.firstname = driver.findElement(By.id(FIRSTNAME_INPUT_ID));
        this.lastname = driver.findElement(By.id(LASTNAME_INPUT_ID));
        this.email = driver.findElement(By.id(EMAIL_INPUT_ID));
        this.telephone = driver.findElement(By.id(TELEPHONE_INPUT_ID));
        this.address = driver.findElement(By.id(ADDRESS_INPUT_ID));
        this.city = driver.findElement(By.id(CITY_INPUT_ID));
        this.postCode = driver.findElement(By.id(POSTCODE_INPUT_ID));
        this.country = new Select(driver.findElement(By.id(COUNTRY_SELECT_ID)));
        this.region = new Select(driver.findElement(By.id(REGION_SELECT_ID)));
        this.password = driver.findElement(By.id(PASSWORD_INPUT_ID));
        this.passwordConfirm = driver.findElement(By.id(PASSWORDCONFIRM_INPUT_ID));
        this.privacyPolicy = driver.findElement(By.cssSelector(PRIVACYPOLICY_CHECKBOX_CSS));
        this.continueButton = driver.findElement(By.cssSelector(CONTINUE_BUTTON_CSS));
    }

	// PageObject

    // get Data

	public WebElement getFirstnameInput() {
		return this.firstname;
	}

	public WebElement getLastnameInput() {
		return this.lastname;
	}

	public WebElement getEmailInput() {
		return this.email;
	}

	public WebElement getTelephoneInput() {
		return this.telephone;
	}

	public WebElement getAddressInput() {
		return this.address;
	}

	public WebElement getCityInput() {
		return this.city;
	}

	public WebElement getPostCodeInput() {
		return this.postCode;
	}

	public Select getCountrySelect() {
		return this.country;
	}

	public Select getRegionSelect() {
		return this.region;
	}

	public WebElement getPasswordInput() {
		return this.password;
	}

	public WebElement getPasswordConfirmInput() {
		return this.passwordConfirm;
	}

	public WebElement getPrivacyPolicyInput() {
		return this.privacyPolicy;
	}

	public WebElement getContinueButtonInput() {
		return this.continueButton;
	}

	// Functional
	
	public String getFirstnameInputText() {
		return getFirstnameInput().getText();
	}

	public String getLastnameInputText() {
		return getLastnameInput().getText();
	}

	public String getEmailInputText() {
		return getEmailInput().getText();
	}

	public String getTelephoneInputText() {
		return getTelephoneInput().getText();
	}

	public String getAddressInputText() {
		return getAddressInput().getText();
	}

	public String getCityInputText() {
		return getCityInput().getText();
	}

	public String getPostCodeInputText() {
		return getPostCodeInput().getText();
	}

	public String getCountrySelectText() {
		return getCountrySelect().getFirstSelectedOption().getText();
	}

	public String getRegionSelectText() {
		return getRegionSelect().getFirstSelectedOption().getText();
	}

	public String getPasswordInputText() {
		return getPasswordInput().getText();
	}

	public String getPasswordConfirmInputText() {
		return getPasswordConfirmInput().getText();
	}

	public boolean isPrivacyPolicyInput() {
		return getPrivacyPolicyInput().isSelected();
	}

	// set Data

	public void setFirstnameInput(String firstname) {
		 getFirstnameInput().sendKeys(firstname);
	}

	public void clearFirstnameInput() {
		 getFirstnameInput().clear();
	}

	public void clickFirstnameInput() {
		 getFirstnameInput().click();
	}

	public void setLastnameInput(String lastname) {
		 getLastnameInput().sendKeys(lastname);
	}

	public void clearLastnameInput() {
		 getLastnameInput().clear();
	}

	public void clickLastnameInput() {
		 getLastnameInput().click();
	}

	public void setEmailInput(String email) {
		 getEmailInput().sendKeys(email);
	}

	public void clearEmailInput() {
		 getEmailInput().clear();
	}

	public void clickEmailInput() {
		 getEmailInput().click();
	}

	public void setTelephoneInput(String telephone) {
		 getTelephoneInput().sendKeys(telephone);
	}

	public void clearTelephoneInput() {
		 getTelephoneInput().clear();
	}

	public void clickTelephoneInput() {
		 getTelephoneInput().click();
	}

	public void setAddressInput(String address) {
		 getAddressInput().sendKeys(address);
	}

	public void clearAddressInput() {
		 getAddressInput().clear();
	}

	public void clickAddressInput() {
		 getAddressInput().click();
	}

	public void setCityInput(String city) {
		 getCityInput().sendKeys(city);
	}

	public void clearCityInput() {
		 getCityInput().clear();
	}

	public void clickCityInput() {
		 getCityInput().click();
	}

	public void setPostCodeInput(String postCode) {
		 getPostCodeInput().sendKeys(postCode);
	}

	public void clearPostCodeInput() {
		 getPostCodeInput().clear();
	}

	public void clickPostCodeInput() {
		 getPostCodeInput().click();
	}

	public void setCountrySelect(String country) {
		getCountrySelect().selectByVisibleText(country);
	}

	public void setRegionSelect(String region) {
		 getRegionSelect().selectByVisibleText(region);
	}

	public void setPasswordInput(String password) {
		 getPasswordInput().sendKeys(password);
	}

	public void clearPasswordInput() {
		 getPasswordInput().clear();
	}

	public void clickPasswordInput() {
		 getPasswordInput().click();
	}

	public void setPasswordConfirmInput(String password) {
		 getPasswordConfirmInput().sendKeys(password);
	}

	public void clearPasswordConfirmInput() {
		 getPasswordConfirmInput().clear();
	}

	public void clickPasswordConfirmInput() {
		 getPasswordConfirmInput().click();
	}

	public void clickPrivacyPolicyInput() {
		 getPrivacyPolicyInput().click();
	}

	public void clickContinueButtonInput() {
		 getContinueButtonInput().click();
	}

	// Business Logic

	public void setClearFirstnameInput(String firstname) {
		clearFirstnameInput();
		setFirstnameInput(firstname);
	}

	public void setClearLastnameInput(String lastname) {
		clearLastnameInput();
		setLastnameInput(lastname);
	}

	public void setClearEmailInput(String email) {
		clearEmailInput();
		setEmailInput(email);
	}

	public void setClearTelephoneInput(String telephone) {
		clearTelephoneInput();
		setTelephoneInput(telephone);
	}

	public void setClearAddressInput(String address) {
		clearAddressInput();
		setAddressInput(address);
	}

	public void setClearCityInput(String city) {
		clearCityInput();
		setCityInput(city);
	}

	public void setClearPostCodeInput(String postCode) {
		clearPostCodeInput();
		setPostCodeInput(postCode);
	}

	public void setClearPasswordInput(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void setClearPasswordConfirmInput(String password) {
		clearPasswordConfirmInput();
		setPasswordConfirmInput(password);
	}

	public void setPrivacyPolicyInputChecked() {
		if (!isPrivacyPolicyInput()) {
			clickPrivacyPolicyInput();
		}
	}

	private void setUserCredentials(IUser user) {
		setClearFirstnameInput(user.getFirstname());
		setClearLastnameInput(user.getLastname());
		setClearEmailInput(user.getEmail());
		setClearTelephoneInput(user.getTelephone());
		setClearAddressInput(user.getAddress());
		setClearCityInput(user.getCity());
		setClearPostCodeInput(user.getPostcode());
		setCountrySelect(user.getCountry());
		setRegionSelect(user.getRegionState());
		setClearPasswordInput(user.getPassword());
		setClearPasswordConfirmInput(user.getPassword());
		setPrivacyPolicyInputChecked();
		clickContinueButtonInput();
	}
	
	public AccountCreatedPage gotoAccountCreated(IUser newUser) {
		setUserCredentials(newUser);
		return new AccountCreatedPage(driver);
	}
}
