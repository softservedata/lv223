package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 30.03.2017.
 */
public abstract class ARightMenuPage extends AMenuPage {

    private static final String MY_ACCOUNT_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'account')]";
    private static final String ADDRESS_BOOK_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'address')]";
    private static final String WISHLIST_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'wishlist')]";
    private static final String ORDER_HISTORY_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'order')]";
    private static final String DOWNLOADS_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'download')]";
    private static final String RECURRING_PAYMENTS_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'recurring')]";
    private static final String REWARD_POINTS_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'reward')]";
    private static final String RETURNS_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'return')]";
    private static final String TRANSACTIONS_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'transaction')]";
    private static final String NEWSLETTER_XPATH_SELECTOR = "//div[@class = 'list-group']/a[contains(@href, 'newsletter')]";


    private WebElement myAccount;
    private WebElement addressBook;
    private WebElement wishList;
    private WebElement orderHistory;
    private WebElement downloads;
    private WebElement recurringPayments;
    private WebElement rewardPoints;
    private WebElement returns;
    private WebElement transactions;
    private WebElement newsletter;


    protected ARightMenuPage(WebDriver driver) {
        super(driver);
        this.myAccount = driver.findElement(By.xpath(MY_ACCOUNT_XPATH_SELECTOR));
        this.addressBook = driver.findElement(By.xpath(ADDRESS_BOOK_XPATH_SELECTOR));
        this.wishList = driver.findElement(By.xpath(WISHLIST_XPATH_SELECTOR));
        this.orderHistory = driver.findElement(By.xpath(ORDER_HISTORY_XPATH_SELECTOR));
        this.downloads = driver.findElement(By.xpath(DOWNLOADS_XPATH_SELECTOR));
        this.recurringPayments = driver.findElement(By.xpath(RECURRING_PAYMENTS_XPATH_SELECTOR));
        this.rewardPoints = driver.findElement(By.xpath(REWARD_POINTS_XPATH_SELECTOR));
        this.returns = driver.findElement(By.xpath(RETURNS_XPATH_SELECTOR));
        this.transactions = driver.findElement(By.xpath(TRANSACTIONS_XPATH_SELECTOR));
        this.newsletter = driver.findElement(By.xpath(NEWSLETTER_XPATH_SELECTOR));
    }

    //----------------get--data----------


//    public WebElement getLoginRight() {
//        return this.loginRight;
//    }
//
//    public WebElement getRegister() {
//        return this.register;
//    }
//
//    public WebElement getForgottenPassword() {
//        return forgottenPassword;
//    }

    public WebElement getMyAccount() {
        return this.myAccount;
    }

    public WebElement getAddressBook() {
        return addressBook;
    }

    public WebElement getWishList() {
        return wishList;
    }

    public WebElement getOrderHistory() {
        return orderHistory;
    }

    public WebElement getDownloads() {
        return downloads;
    }

    public WebElement getRecurringPayments() {
        return recurringPayments;
    }

    public WebElement getRewardPoints() {
        return rewardPoints;
    }

    public WebElement getReturns() {
        return returns;
    }

    public WebElement getTransactions() {
        return transactions;
    }

    public WebElement getNewsletter() {
        return newsletter;
    }

    //------------------------set---data----------


//    public void clickLoginRight() {
//        getLoginRight().click();
//    }
//
//    public void clickRegister() {
//        getRegister().click();
//    }
//
//    public void clickForgottenPassword() {
//        getForgottenPassword().click();
//    }

    public void clickMyAccount() {
        getMyAccount().click();
    }

    public void clickAddressBook() {
        getAddressBook().click();
    }

    public void clickWishList() {
        getWishList().click();
    }

    public void clickOrderHistory() {
        getOrderHistory().click();
    }

    public void clickDownloads() {
        getDownloads().click();
    }

    public void clickRecurringPayments() {
        getRecurringPayments().click();
    }

    public void clickRewardPoints() {
        getRewardPoints().click();
    }

    public void clickReturns() {
        getReturns().click();
    }

    public void clickTransactions() {
        getTransactions().click();
    }

    public void clickNewsletter() {
        getNewsletter().click();
    }

    //-------------functional------------


    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    public String getAddressBookText() {
        return getAddressBook().getText();
    }

    public String getWishListText() {
        return getWishList().getText();
    }

    public String getOrderHistoryText() {
        return getOrderHistory().getText();
    }

    public String getDownloadsText() {
        return getDownloads().getText();
    }

    public String getRecurringPaymentsText() {
        return getRecurringPayments().getText();
    }

    public String getRewardPointsText() {
        return getRewardPoints().getText();
    }

    public String getReturnsText() {
        return getReturns().getText();
    }

    public String getTransactionsText() {
        return getTransactions().getText();
    }

    public String getNewsletterText() {
        return getNewsletter().getText();
    }

    // ---------------PageObject


    //----------------BusinessLogic

    public abstract ARightMenuPage gotoMyAccountPage();

    public abstract ARightMenuPage gotoAddressBookPage();

    public abstract ARightMenuPage gotoWishListPage();

    public abstract ARightMenuPage gotoOrderHistoryPage();

    public abstract ARightMenuPage gotoDownloadsPage();

    public abstract ARightMenuPage gotoRecurringPaymentsPage();

    public abstract ARightMenuPage gotoRewardPointsPage();

    public abstract ARightMenuPage gotoReturns();

    public abstract ARightMenuPage gotoTransactions();

    public abstract ARightMenuPage gotoNewsletter();

}
