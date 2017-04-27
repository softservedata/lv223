package com.softserve.edu.opencart.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.ApplicationSourcesRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.LoginPage;
import com.softserve.edu.opencart.pages.ProductComponent;
import com.softserve.edu.opencart.pages.ReturningCustomerPage;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.pages.WishListComponent;
import com.softserve.edu.opencart.pages.WishListPage;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;

public class WishListRowsTest {

	@BeforeTest
	public void doBeforeTest() {
		System.setProperty("webdriver.chrome.driver",
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
	}
	
	
	@Parameters("RootUrl")
	@Test()
	public void wishtListTest(@Optional("http://atqc-shop.epizy.com/") String rootUrl) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(rootUrl);
		
		HomePage homepage = new HomePage(driver);
		VerticalMenuPage verticalMenuPage = homepage.gotoShowAll(CategoryRepository.COMPONENTS);
		ProductComponent productComponent = verticalMenuPage.getProductByIndex(0);
		productComponent.clickWishList();
		String productNameWichIsAddedToWishList = productComponent.getDetailsLinkText();

		ReturningCustomerPage returningCustomerPage = (ReturningCustomerPage) verticalMenuPage.gotoWishListPageTop();
		returningCustomerPage.getEmail().sendKeys("orlann@ukr.net");
		returningCustomerPage.getPassword().sendKeys("qwerty");

		WishListPage wishListPage = returningCustomerPage.clickLoginButton();

		if (wishListPage == null) {
			throw new InterruptedException(ReturningCustomerPage.INCORRECT_LOGIN_DATA_MESSAGE);
		}

		List<WishListComponent> wishComponents = wishListPage.getWishComponentList();

		if (wishComponents == null) {
			throw new InterruptedException(WishListComponent.WISH_LIST_EMPTY_MESSAGE);
		}

		int wishComponentListBeforeRemovingSize = wishComponents.size();

		WishListComponent wishComponentToCheck = wishListPage
				.getWishListComponentByProductName(productNameWichIsAddedToWishList);
		wishComponentToCheck.clickRemove();

		List<WishListComponent> wishComponentsAfterRemoving = wishListPage.getComponents();
		int wishComponentListAfterRemovingSize = wishComponentsAfterRemoving.size();

		Assert.assertEquals(wishComponentListBeforeRemovingSize, wishComponentListAfterRemovingSize + 1);

		boolean isExistAddedProduct = wishListPage.isComponentExistInWishList(productNameWichIsAddedToWishList);
		Assert.assertTrue(!isExistAddedProduct);
		//Assert.assertFalse(isExistAddedProduct);

		driver.close();

	}
}