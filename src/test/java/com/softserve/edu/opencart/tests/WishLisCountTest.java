package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.ApplicationSourcesRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.ProductComponent;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.tools.CountUtils;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;

public class WishLisCountTest {
	@Test
	public void WistListTopTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
		ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://atqc-shop.epizy.com/");
		
		HomePage homepage = new HomePage(driver);
		VerticalMenuPage verticalMenuPage = homepage.gotoShowAll(CategoryRepository.DESKTOPS);
		String currentWishList = verticalMenuPage.getWishListTopText();
		String currentWishListCount = CountUtils.getTextInBrackets(currentWishList);
		System.out.println(currentWishListCount);
		Assert.assertEquals( "0", currentWishListCount);
		
		ProductComponent productComponent = verticalMenuPage.getProductByIndex(0);
		productComponent.clickWishList();
		
//		Thread.sleep(2000);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		System.out.println("******** = "+ currentWishList);
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("i.fa.fa-heart span"), currentWishList));
// 		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String changedWishList = verticalMenuPage.getWishListTopText();
		String targetWishListCount = CountUtils.getTextInBrackets(changedWishList);
		System.out.println(targetWishListCount);
		Assert.assertEquals( "1", targetWishListCount);
		driver.quit();
	}

}
