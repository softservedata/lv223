package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.HomePageFactory;

public class RegistrationTest {

    @Test
    public void checkSearch() throws Exception {
        // Precondition
        System.setProperty("webdriver.chrome.driver",
                SearchTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get("http://atqc-shop.epizy.com/");
        Thread.sleep(1000);
        //
        // Steps
        HomePageFactory homePageFactory = new HomePageFactory(driver); // 1st item
        //
        homePageFactory = homePageFactory.gotoMyAccountPage();
        homePageFactory = homePageFactory.gotoRegistrationPage();
        homePageFactory = homePageFactory.gotoFirstNameItem("Bob");
        homePageFactory = homePageFactory.gotoLastNameItem("Smith");
        homePageFactory = homePageFactory.gotoEmailItem("bob18@gmail.com");
        homePageFactory = homePageFactory.gotoTelephoneItem("0963265987");
        homePageFactory = homePageFactory.gotoAddressItem("baker street 221b");
        homePageFactory = homePageFactory.gotoCityItem("London");
        homePageFactory = homePageFactory.gotoPostCodeItem("1844");
        homePageFactory = homePageFactory.gotoRegionStateItem("c");
        homePageFactory = homePageFactory.gotoPasswordItem("qwerty1");
        homePageFactory = homePageFactory.gotoPasswordConfirmItem("qwerty1");
        homePageFactory = homePageFactory.gotoAgreeItem();
        homePageFactory = homePageFactory.gotoContinueItem();
        Thread.sleep(2000);
        //HomePageFactory loginPage = homePageFactory.gotoRegistrationPage();
        //homePageFactory.sendKeysSearchInput("ha-ha-ha");
        //Thread.sleep(2000);
        //driver.navigate().refresh();
        //Thread.sleep(2000);
        //homePageFactory.clearSearchInput();
        //homePageFactory.sendKeysSearchInput("iMac");
        //homePageFactory.clickSearchButton();
        //homePageFactory = PageFactory.initElements(driver, HomePageFactory.class); // 2nd item

        //
        // Check
        //Assert.assertEquals(homePageFactory.getSearchInputText(), "iMac");
        //Assert.assertTrue(homePageFactory.isWebElementPresentByPartialLinkText("iMac"));
        //
        // Return to previous state
        Thread.sleep(2000);
        driver.quit();
    }
}

