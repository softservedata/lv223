package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 24.03.2017.
 */
public abstract class ARightMenuUnregister extends ARightMenuPage {

    //----------------fields----------

    private static final String LOGIN_RIGHT_XPATH_SELECTOR = "//a[contains(@href, 'login')]";
    private static final String REGISTER_XPATH_SELECTOR = "//a[contains(@href, 'register')]";
    private static final String FORGOTTEN_PASSWORD_XPATH_SELECTOR = "//a[contains(@href, 'forgotten')]";


    private WebElement loginRight;
    private WebElement register;
    private WebElement forgottenPassword;

    protected ARightMenuUnregister(WebDriver driver) {
        super(driver);
        this.loginRight = driver.findElement(By.xpath(LOGIN_RIGHT_XPATH_SELECTOR));
        this.register = driver.findElement(By.xpath(REGISTER_XPATH_SELECTOR));
        this.forgottenPassword = driver.findElement(By.xpath(FORGOTTEN_PASSWORD_XPATH_SELECTOR));
    }

    //=========================GET_DATA==========================

    public WebElement getLoginRight() {
        return this.loginRight;
    }

    public WebElement getRegister() {
        return this.register;
    }

    public WebElement getForgottenPassword() {
        return forgottenPassword;
    }


    //=======================SET_DATA===================

    public void clickLoginRight() {
        getLoginRight().click();
    }

    public void clickRegister() {
        getRegister().click();
    }

    public void clickForgottenPassword() {
        getForgottenPassword().click();
    }

    //=======================Functional===========================

    public String getLoginRightText() {
        return getLoginRight().getText();
    }

    public String getRegisterText() {
        return getRegister().getText();
    }

    public String getForgottenPasswordText() {
        return getForgottenPassword().getText();
    }


    //===========================Business_logic=====================

    public LoginPage gotoLoginPage(){
        clickLogin();
        return new LoginPage(driver);
    }

    public RegisterPage gotoRegisterPage() {
        clickRegister();
        return new RegisterPage(driver);
    }

    public ForgottenPasswordPage gotoForgottenPasswordPage() {
        clickForgottenPassword();
        return new ForgottenPasswordPage(driver);
    }

    @Override
    public LoginPage gotoMyAccountPage(){
        clickMyAccount();
        return new LoginPage(driver);
    }

    @Override
    public ARightMenuPage gotoAddressBookPage(){
        clickAddressBook();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoWishListPage(){
        clickWishList();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoOrderHistoryPage(){
        clickOrderHistory();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoDownloadsPage(){
        clickDownloads();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoRecurringPaymentsPage(){
        clickRecurringPayments();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoRewardPointsPage(){
        clickRewardPoints();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoReturns(){
        clickReturns();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoTransactions(){
        clickTransactions();
        return new LoginPage(driver);
    };

    @Override
    public ARightMenuPage gotoNewsletter(){
        clickNewsletter();
        return new LoginPage(driver);
    };

}
