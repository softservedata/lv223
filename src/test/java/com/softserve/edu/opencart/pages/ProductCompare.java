package com.softserve.edu.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCompare extends AMenuPage{
	private List<WebElement> descriptionOfElements;
	
	protected ProductCompare(WebDriver driver) {
		super(driver);
		descriptionOfElements = driver.findElements(By.cssSelector(".table-bordered a>strong"));
	}
	
	public boolean isComparedProductExistInTheList(String nameOfProduct){
		int i = 0;
		boolean condition = false;
		for(WebElement productsName : descriptionOfElements){
			if(nameOfProduct.equals(descriptionOfElements.get(i).getText())){
				condition = true;
				break;
			}	
			i++;
		}
		return condition;
	}
}
