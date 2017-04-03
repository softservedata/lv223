package com.softserve.edu.opencart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.ApplicationSourcesRepository;

public class Smoke {

	//@Test
	public void testSmoke() throws Exception {
		// Must be from Selenium ver. 3.0 or later
		//System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//
		System.setProperty("webdriver.chrome.driver",
		//		"./lib/chromedriver.exe");
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua/");
		Thread.sleep(2000);
		//
		// driver.findElement(By.id("lst-ib")).clear();
		// driver.findElement(By.id("lst-ib")).sendKeys("selenium IDE
		// download");
		//
		// Bad Solution
		WebElement searchField = driver.findElement(By.id("lst-ib"));
		searchField.clear();
		searchField.sendKeys("selenium IDE download");
		Thread.sleep(2000);
		//
		driver.findElement(By.id("_fZl")).click();
		Thread.sleep(2000);
		//
		driver.findElement(By.linkText("Download Selenium IDE")).click();
		Thread.sleep(2000);
		//
		WebElement actual = driver.findElement(By.partialLinkText("Selenium IDE can be extended"));
		String actualText = actual.getText().trim();
		String expectedText = "Selenium IDE can be extended through its own plugin system. Here are a number of plugins that have been created using it. For more information on how to create your own plugin or have it listed, see the";
		Assert.assertEquals(actualText, expectedText);
		//
		Thread.sleep(4000);
		driver.quit();
	}

	@Test
	public void testInject() throws Exception {
		System.setProperty("webdriver.chrome.driver",
		//		"./lib/chromedriver.exe");
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua/");
		Thread.sleep(2000);
		//
		WebElement searchField = driver.findElement(By.id("lst-ib"));
		searchField.clear();
		searchField.sendKeys("selenium IDE download");
		Thread.sleep(2000);
		//
		searchField.submit();
		Thread.sleep(2000);
		//
		driver.findElement(By.linkText("Download Selenium IDE")).click();
		Thread.sleep(2000);
		//
		((JavascriptExecutor)driver)
		                .executeScript("alert('Ha-Ha-Ha')"); 
		Thread.sleep(2000);
		//
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//
		// Search JS
//		WebElement visgrid = (WebElement)
//		        ((JavascriptExecutor)driver)
//		                .executeScript("return $('.name')[1]");
		//
		//  Search Implicit
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		List<WebElement> visgrids = driver.findElements(By.className("name"));
//		WebElement visgrid = visgrids.get(1);
		//
		// driver.findElement is equivalent to ExpectedConditions.presenceOfElementLocated(By locator)
//		WebElement visgrid = driver.findElement(By.xpath("//div[contains(text(), 'VisGrid-UI')]"));
		//
		//  Search Eplicit https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement visgrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'VisGrid-UI')]")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		// Scroll
		Actions action = new Actions(driver);
		action.moveToElement(visgrid).perform();
		Thread.sleep(1000);
		//
		System.out.println("visgrid=" + visgrid.getText());
		Assert.assertTrue(visgrid.getText().toLowerCase().contains("visgrid"));
		Thread.sleep(1000);
		//
		// Set Focus
		visgrid = driver.findElement(By.partialLinkText("previous versions here"));
		action.moveToElement(visgrid).perform();
		visgrid.sendKeys("");
		visgrid.sendKeys(Keys.ENTER);
		//
		Thread.sleep(4000);
		driver.quit();
	}

	//@Test
	public void testSelect() throws Exception {
		System.setProperty("webdriver.chrome.driver",
		//		"./lib/chromedriver.exe");
				ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://registrator.herokuapp.com/");
		Thread.sleep(2000);
		//
		WebElement select = driver.findElement(By.id("changeLanguage"));
		List<WebElement> allOptions = select.findElements(By.tagName("option"));
		for (WebElement option : allOptions) {
		    System.out.println(String.format("Value is: %s \ttext is: %s",
		            option.getAttribute("value"), option.getText()));
		    //option.click( );  // Error
		    Thread.sleep(2000);
		}
		//
		Select selectUI = new Select(driver.findElement(By.id("changeLanguage")));
		//selectUI.deselectAll();
		selectUI.selectByVisibleText("english");
		//
		Thread.sleep(4000);
		driver.quit();
	}

}

