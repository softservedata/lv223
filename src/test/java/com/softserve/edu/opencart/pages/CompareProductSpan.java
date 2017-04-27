package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareProductSpan{
	
	public final WebElement productCompareDescription;
	public final WebElement comparePageLink;
	private WebDriver driver;
	
	public CompareProductSpan(WebDriver driver)	{
		this.driver = driver;
		this.comparePageLink = driver.findElement(By.cssSelector(".alert-success>a[href$=compare]"));
		this.productCompareDescription = driver.findElement(By.cssSelector(".alert-success>a[href*=id]"));
	}
	
	//Functional
	public String getProductCompareDescriptionText(){
		return productCompareDescription.getText();
	}
	//setData
	public ProductCompare getComparePageLink(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(comparePageLink));
		comparePageLink.click();
		return new ProductCompare(driver);
	}

}
