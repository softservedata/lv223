package com.softserve.edu.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TODO Rename
public class ProductCompare {
	private WebDriver driver;
	private List<WebElement> descriptionOfElements;
	
	public ProductCompare(WebDriver driver) {
		this.driver = driver;
		this.descriptionOfElements = driver.findElements(By.cssSelector(".table-bordered a>strong"));
	}
	
	// TODO Move method to AProductListPage ?
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
