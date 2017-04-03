package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ARightMenuUnregister{

	private static final String LOGIN_BUTTON_XPATH_SELECTOR = "//input[@value = 'Login']";
	private static final String FORGOTTEN_PASSWORD_LINK_TEXT_SELECTOR = "Forgotten Password";
	private static final String CONTINUE_BUTTON_CSS_SELECTOR = "div a.btn-primary";
	private static final String EMAIL_FIELD_CSS_SELECTOR = "#input-email";
	private static final String PASSWORD_FIELD_CSS_SELECTOR = "#input-password";

	//TODO
	private static final String VALIDATION_ALERT_CSS_SELECTOR = ".alert.alert-danger";

	private WebElement loginButton;
	private WebElement forgottenPassword;
	private WebElement continueButton;
	private WebElement emailField;
	private WebElement passwordField;

	protected LoginPage(WebDriver driver) {
		super(driver);
		this.loginButton = driver.findElement(By.xpath(LOGIN_BUTTON_XPATH_SELECTOR));
		this.continueButton = driver.findElement(By.cssSelector(CONTINUE_BUTTON_CSS_SELECTOR));
		this.forgottenPassword = driver.findElement(By.linkText(FORGOTTEN_PASSWORD_LINK_TEXT_SELECTOR));
		this.emailField = driver.findElement(By.cssSelector(EMAIL_FIELD_CSS_SELECTOR));
		this.passwordField = driver.findElement(By.cssSelector(PASSWORD_FIELD_CSS_SELECTOR));
	}

	public WebElement getLoginButton() {
		return this.loginButton;
	}

	public WebElement getForgottenPassword() {
		return this.forgottenPassword;
	}

	public WebElement getContinueButton() {
		return this.continueButton;
	}

	public WebElement getEmailField() {
		return this.emailField;
	}

	public WebElement getPasswordField() {
		return this.passwordField;
	}

	// ToDO
	// Returning customer block, login button, email field, password field
	//

	// -------set data------------------------


	public void clickLoginButton() {
		getLoginButton().click();
	}

	public void clickForgottenPassword() {
		getForgottenPassword().click();
	}

	public void clickContinueButton() {
		getContinueButton().click();
	}

	public void clickEmailField() {
		getEmailField().click();
	}

	public void clickPasswordField() {
		getPasswordField().click();
	}

	public void setEmail(String email) {

		getEmailField().sendKeys(email);
	}

	public void setPassword(String password) {

		getPasswordField().sendKeys(password);
	}

	// ------------------Functional-----------

	public String getLoginButtonText() {
		return getLoginButton().getText();
	}

	public String getForgottenPasswordText() {
		return getForgottenPassword().getText();
	}

	public String getContinueButtonText() {
		return getContinueButton().getText();
	}

	public String getEmailFieldText() {
		return getEmailField().getText();
	}

	public String getPasswordFieldText() {
		return getPasswordField().getText();
	}

    //=====================Business_Logic=================

	public void setLoginCredentials(IUser user){
		setEmail(user.getEmail());
		setPassword(user.getPassword());
		clickLoginButton();
	}

	public MyAccountPage successUserLogin(IUser user) {
		setLoginCredentials(user);
		return new MyAccountPage(driver);
	}

//  public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {}

}
