package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.opencart.pages.HomePageFactory;

public class SearchTest {
	
	//@Test
	public void checkSearch() throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
		//		"./lib/chromedriver.exe");
				SearchTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://atqc-shop.epizy.com/");
		Thread.sleep(1000);
		//
		// Steps
		HomePageFactory homePageFactory = new HomePageFactory(driver); // 1st item
		//HomePageFactory homePageFactory = PageFactory.initElements(driver, HomePageFactory.class); // 2nd item
		//
		homePageFactory.sendKeysSearchInput("ha-ha-ha");
		Thread.sleep(2000);
		//driver.navigate().refresh();
		//Thread.sleep(2000);
		//homePageFactory.clearSearchInput();
		//homePageFactory.sendKeysSearchInput("iMac");
		//homePageFactory.clickSearchButton();
		//homePageFactory = PageFactory.initElements(driver, HomePageFactory.class); // 2nd item
		homePageFactory = homePageFactory.gotoSearchItem("iMac");
		//
		// Check
		Assert.assertEquals(homePageFactory.getSearchInputText(), "iMac");
		Assert.assertTrue(homePageFactory.isWebElementPresentByPartialLinkText("iMac"));
		//
		// Return to previous state
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void checkSearchSoftAssert() throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
		//		"./lib/chromedriver.exe");
				SearchTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://atqc-shop.epizy.com/");
		Thread.sleep(1000);
		//
		SoftAssert softAssert = new SoftAssert();
		//
		// Steps
		HomePageFactory homePageFactory = new HomePageFactory(driver); // 1st item
		//HomePageFactory homePageFactory = PageFactory.initElements(driver, HomePageFactory.class); // 2nd item
		//
		homePageFactory.sendKeysSearchInput("ha-ha-ha");
		Thread.sleep(2000);
		//driver.navigate().refresh();
		//Thread.sleep(2000);
		//homePageFactory.clearSearchInput();
		//homePageFactory.sendKeysSearchInput("iMac");
		//homePageFactory.clickSearchButton();
		//homePageFactory = PageFactory.initElements(driver, HomePageFactory.class); // 2nd item
		homePageFactory = homePageFactory.gotoSearchItem("iMac");
		//
		// Check
		softAssert.assertEquals(homePageFactory.getSearchInputText(), "iMac_ERROR");
		softAssert.assertTrue(homePageFactory.isWebElementPresentByPartialLinkText("iMac"));
		//
		// Return to previous state
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Test DONE, before softAssert.assertAll();");
		softAssert.assertAll();
		System.out.println("Test DONE, after softAssert.assertAll();");
	}

}
