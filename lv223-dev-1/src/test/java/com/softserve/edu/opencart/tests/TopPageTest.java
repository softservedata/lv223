package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.TopPage;

public class TopPageTest {
	
	// Temporary tests
	@Test
	public void checkComponent() throws InterruptedException {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		//options.addArguments("--start-maximized"); // DELETE
		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://atqc-shop.epizy.com/");
		Thread.sleep(2000);
		//
		// Steps
		TopPage topPage = new TopPage(driver);
		topPage.clickEuro();
		Thread.sleep(2000);
		topPage = new TopPage(driver);
		//
		topPage.clickContact();
		Thread.sleep(2000);
		topPage = new TopPage(driver);
		//
		topPage.clickLogin();
		Thread.sleep(2000);
		topPage = new TopPage(driver);
		//
		topPage.sendKeysSearchInput("Mac");
		Thread.sleep(2000);
		//
		// Check
		Assert.assertEquals("mac",
				topPage.getSearchInputText().toLowerCase());
		Thread.sleep(2000);
		//
		// Return to previous state
		driver.quit();
	}

}
