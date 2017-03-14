package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.VerticalMenuPage;

public class ProductTest {

	@Test
	public void checkComponent() throws InterruptedException {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		options.addArguments("--start-maximized"); // DELETE
		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://atqc-shop.epizy.com/");
		Thread.sleep(1000);
		//
		// Steps
		HomePage homePage = new HomePage(driver);
		Thread.sleep(1000);
		//
		VerticalMenuPage verticalMenuPage = homePage.gotoDesktopsAll();
		Thread.sleep(1000);
		//
		// Check
//		System.out.println("+++ Result = " + verticalMenuPage.getProductByDetailsLink("iMac")
//				.getDescriptionText().trim().toLowerCase());
		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink("iMac")
				.getDescriptionText().trim().toLowerCase()
				.contains("just when you thought imac had everything,"));
		Thread.sleep(1000);
		//
		// Steps
		verticalMenuPage = verticalMenuPage.gotoVertDesktopsPc();
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(verticalMenuPage.getProductsListSize() == 0);
		System.out.println(verticalMenuPage.getDesktops() + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Assert.assertTrue(verticalMenuPage.getVertPcCount() == 0);
		Thread.sleep(1000);
		//
		// Steps
		verticalMenuPage = verticalMenuPage.gotoVertDesktopsMac();
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink("iMac")
				.getDescriptionText().trim().toLowerCase()
				.contains("just when you thought imac had everything,"));
		Thread.sleep(2000);
		//
		// Return to previous state
		driver.quit();
	}
	
}
