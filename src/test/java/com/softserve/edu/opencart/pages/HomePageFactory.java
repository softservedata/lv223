package com.softserve.edu.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    // @CacheLookup
    @FindBy(css = "input.form-control.input-lg")
    private WebElement searchInput;
    //
    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;
    //
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")
    private WebElement myAccountButton;
    //
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a")
    private WebElement registrationButton;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[1]/div[2]/div/input")
    private WebElement firstNameInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[1]/div[3]/div/input")
    private WebElement lastNameInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[1]/div[4]/div/input")
    private WebElement emailInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[1]/div[5]/div/input")
    private WebElement telephoneInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[2]/div[2]/div/input")
    private WebElement addressInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[2]/div[4]/div/input")
    private WebElement cityInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[2]/div[5]/div/input")
    private WebElement postCodeInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[2]/div[7]/div/select")
    private WebElement regionStateInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[3]/div[1]/div/input")
    private WebElement passwordInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset[3]/div[2]/div/input")
    private WebElement passwordConfirmInput;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/input[1]")
    private WebElement agreeButton;
    //
    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/input[2]")
    private WebElement continueButton;


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

    public WebElement getMyAccountButton() {
        return this.myAccountButton;
    }

    public WebElement getRegistrationButton() {
        return this.registrationButton;
    }

    public WebElement getFirstNameInput() {
        return this.firstNameInput;
    }

    public WebElement getLastNameInput() {
        return this.lastNameInput;
    }

    public WebElement getEmailInput() {
        return this.emailInput;
    }

    public WebElement getTelephoneInput() {
        return this.telephoneInput;
    }

    public WebElement getAddressInput() {
        return this.addressInput;
    }

    public WebElement getCityInput() {
        return this.cityInput;
    }

    public WebElement getPostCodeInput() {
        return this.postCodeInput;
    }

    public WebElement getRegionStateInput() {
        return this.regionStateInput;
    }

    public WebElement getPasswordInput() {
        return this.passwordInput;
    }

    public WebElement getPasswordConfirmInput() {
        return this.passwordConfirmInput;
    }

    public WebElement getAgreeButton() {
        return this.agreeButton;
    }

    public WebElement getContinueButton() {
        return this.continueButton;
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

    public void clickRegistrationButton() {
        getRegistrationButton().click();
    }

    public void clickMyAccountButton() {
        getMyAccountButton().click();
    }

    public void clearFirstNameInput() {
        getFirstNameInput().clear();
    }

    public void clearLastNameInput() {
        getLastNameInput().clear();
    }

    public void clearEmailInput() {
        getEmailInput().clear();
    }

    public void clearTelephoneInput() {
        getTelephoneInput().clear();
    }

    public void sendKeysSearchInput(String text) {
        getSearchInput().sendKeys(text);
    }

    public void sendKeysFirstNameInput(String text) {
        getFirstNameInput().sendKeys(text);
    }

    public void sendKeysLastNameInput(String text) {
        getLastNameInput().sendKeys(text);
    }

    public void sendKeysEmailInput(String text) {
        getEmailInput().sendKeys(text);
    }

    public void sendKeysTelephoneInput(String text) {
        getTelephoneInput().sendKeys(text);
    }

    public void sendKeysAddressInput(String text) {
        getAddressInput().sendKeys(text);
    }

    public void sendKeysCityInput(String text) {
        getCityInput().sendKeys(text);
    }

    public void sendKeysPostCodeInput(String text) {
        getPostCodeInput().sendKeys(text);
    }

    public void sendKeysRegionStateInput(String text) {
        getRegionStateInput().sendKeys(text);
    }

    public void sendKeysPasswordInput(String text) {
        getPasswordInput().sendKeys(text);
    }

    public void sendKeysPasswordConfirmInput(String text) {
        getPasswordConfirmInput().sendKeys(text);
    }

    public void clickAgreeButton() {
        getAgreeButton().click();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Business Logic

    public HomePageFactory gotoSearchItem(String text) {
        clearSearchInput();
        sendKeysSearchInput(text);
        clickSearchButton();
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoMyAccountPage() {
        clickMyAccountButton();
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoRegistrationPage() {
        clickRegistrationButton();
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoFirstNameItem(String text) {
        clearSearchInput();
        sendKeysFirstNameInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoLastNameItem(String text) {
        clearSearchInput();
        sendKeysLastNameInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoEmailItem(String text) {
        clearSearchInput();
        sendKeysEmailInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoTelephoneItem(String text) {
        clearSearchInput();
        sendKeysTelephoneInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoAddressItem(String text) {
        clearSearchInput();
        sendKeysAddressInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoCityItem(String text) {
        clearSearchInput();
        sendKeysCityInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoPostCodeItem(String text) {
        clearSearchInput();
        sendKeysPostCodeInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoRegionStateItem(String text) {
        clearSearchInput();
        sendKeysRegionStateInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoPasswordItem(String text) {
        clearSearchInput();
        sendKeysPasswordInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoPasswordConfirmItem(String text) {
        clearSearchInput();
        sendKeysPasswordConfirmInput(text);
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoAgreeItem() {
        clickAgreeButton();
        return new HomePageFactory(driver);
    }

    public HomePageFactory gotoContinueItem() {
        clickContinueButton();
        return new HomePageFactory(driver);
    }
}
