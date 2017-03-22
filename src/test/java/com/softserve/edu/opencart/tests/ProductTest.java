package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.ApplicationSourcesRepository;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.tools.CountUtils;

public class ProductTest {

	@DataProvider//(parallel = true)
    public Object[][] desctopProducts() {
        return new Object[][] {
            { ProductRepository.getDesktopIMac() }
        };
        //return ProviderUtils.toMultiArray(ProductRepository.getDesktopIMacs());
    }
	
	@Test(dataProvider = "desctopProducts")
	public void checkComponent(Product product) throws InterruptedException {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				//"./lib/chromedriver.exe");
		ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		//
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
		VerticalMenuPage verticalMenuPage = homePage.gotoShowAll(CategoryRepository.DESKTOPS);
		verticalMenuPage = verticalMenuPage.gotoCurrencyUSDollar();
		Thread.sleep(1000);
		//
		// Check
//		System.out.println("+++ Result = " + verticalMenuPage.getProductByDetailsLink("iMac")
//				.getDescriptionText().trim().toLowerCase());
//		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink("iMac")
//				.getDescriptionText().trim().toLowerCase()
//				.contains("just when you thought imac had everything,"));
		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink(product.getDetails())
				.getDescriptionText().trim().toLowerCase()
				.contains(product.getDescription().toLowerCase()));
		Thread.sleep(1000);
		//
		// Steps
		//verticalMenuPage = verticalMenuPage.gotoVertDesktopsPc();
		//verticalMenuPage = verticalMenuPage.gotoVertMenuSubCategory(CategoryRepository.DESKTOPS, "PC");
		verticalMenuPage = verticalMenuPage.gotoVertMenuSubCategory(
				ProductRepository.getDesktopPc().getCategory(),
				ProductRepository.getDesktopPc().getSubCategory());
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(verticalMenuPage.getProductsListSize() == 0);
		
		//Assert.assertTrue(verticalMenuPage.getVertPcCount() == 0);
//		Assert.assertTrue(verticalMenuPage
//				.getVerticalMenuSubCategoryCount(CategoryRepository.DESKTOPS, "PC") == 0);
		
		Thread.sleep(1000);
		//
		// Steps
		//verticalMenuPage = verticalMenuPage.gotoVertDesktopsMac();
		verticalMenuPage = verticalMenuPage.gotoVertMenuSubCategory(
				product.getCategory(), product.getSubCategory());
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink(product.getDetails())
				.getDescriptionText().trim().toLowerCase()
				.contains(product.getDescription().toLowerCase()));
		String actualPrice = verticalMenuPage.getProductByDetailsLink(product.getDetails()).getPriceText();
		Assert.assertEquals(CountUtils.getPriceInText(actualPrice),
				CountUtils.getPriceInText(product.getPrice()), 0.01);
		Thread.sleep(2000);
		//
		// Return to previous state
		driver.quit();
	}

}
