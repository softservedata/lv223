package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 30.03.2017.
 */
public class ARightMenuRegistered extends ARightMenuPage {

   //fields

    private static final String EDIT_ACCOUNT_XPATH_SELECTOR = "//a[contains(@href, 'edit')]";
    private static final String PASSWORD_XPATH_SELECTOR = "//a[contains(@href, 'password')]";
    private static final String LOGOUT_PASSWORD_XPATH_SELECTOR = "//a[contains(@href, 'logout')]";

    private WebElement editAccount;
    private WebElement password;
    private WebElement logout;

    protected ARightMenuRegistered(WebDriver driver) {
        super(driver);
        this.editAccount = driver.findElement(By.xpath(EDIT_ACCOUNT_XPATH_SELECTOR));
        driver.findElement(By.xpath(PASSWORD_XPATH_SELECTOR));
        driver.findElement(By.xpath(LOGOUT_PASSWORD_XPATH_SELECTOR));
    }

    //=======================GET_DATA===============================

    public WebElement getEditAccount() {
        return this.editAccount;
    }

    public WebElement getPassword() {
        return this.password;
    }

    public WebElement getLogout() {
        return this.logout;
    }

    //=======================SET_DATA===============================

    public void clickEditAccount() {

        getEditAccount().click();
    }

    public void clickPassword() {

        getPassword().click();
    }

    public void clickLogout() {

        getLogout().click();
    }

    //=======================business_logic=========================


    public ARightMenuPage gotoEditAccountPage() {
        clickEditAccount();
        return new EditAccountPage(driver);
    }

    public ARightMenuPage gotoChangePasswordPage() {
        clickPassword();
        return new ChangePasswordPage(driver);
    }

    public ARightMenuPage gotoLogoutPage() {
        clickLogout();
        return new LogoutPage(driver);
    }

    @Override
    public ARightMenuPage gotoMyAccountPage() {
        clickMyAccount();
        return new MyAccountPage(driver);
    }

    @Override
    public ARightMenuPage gotoAddressBookPage() {
        clickAddressBook();
        return new AddressBookPage(driver);
    }

    @Override
    public ARightMenuPage gotoWishListPage() {
        clickWishList();
        return new WishListPage(driver);
    }

    @Override
    public ARightMenuPage gotoOrderHistoryPage() {
        clickOrderHistory();
        return new OrderHistoryPage(driver);
    }

    @Override
    public ARightMenuPage gotoDownloadsPage() {
        clickDownloads();
        return new DownloadsPage(driver);
    }

    @Override
    public ARightMenuPage gotoRecurringPaymentsPage() {
        clickRecurringPayments();
        return new RecurringPaymentsPage(driver);
    }

    @Override
    public ARightMenuPage gotoRewardPointsPage() {
        clickRewardPoints();
        return new RewardPointsPage(driver);
    }

    @Override
    public ARightMenuPage gotoReturns() {
        clickReturns();
        return new ReturnsPage(driver);
    }

    @Override
    public ARightMenuPage gotoTransactions() {
        clickTransactions();
        return new TransactionsPage(driver);
    }

    @Override
    public ARightMenuPage gotoNewsletter() {
        clickNewsletter();
        return new NewsletterPage(driver);
    }
}
