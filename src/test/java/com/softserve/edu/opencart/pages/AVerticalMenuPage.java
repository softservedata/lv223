package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AVerticalMenuPage extends AMenuPage {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class DesktopsAVerticalMenuPage {
		public final WebElement vertPc;
		public final WebElement vertMac;

		public DesktopsAVerticalMenuPage() {
    		this.vertPc = driver.findElement(By.partialLinkText("- PC ("));
    		this.vertMac = driver.findElement(By.partialLinkText("- Mac ("));
    	}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields
	
	private WebElement home;
	//
	// Vertical Menu
	private WebElement vertDesktops;
	private DesktopsAVerticalMenuPage vertDesktopsMenu;
	private WebElement vertLaptops;
	private WebElement vertComponents;
	private WebElement vertTablets;
	private WebElement vertSoftware;
	private WebElement vertPhones;
	private WebElement vertCameras;
	private WebElement vertPlayers;

	
	protected AVerticalMenuPage(WebDriver driver) {
		super(driver);
		this.vertDesktops = driver.findElement(By.partialLinkText("Desktops ("));
		this.vertLaptops = driver.findElement(By.partialLinkText("Laptops & Notebooks ("));
		this.vertComponents = driver.findElement(By.partialLinkText("Components ("));
		this.vertTablets = driver.findElement(By.partialLinkText("Tablets ("));
		this.vertSoftware = driver.findElement(By.partialLinkText("Software ("));
		this.vertPhones = driver.findElement(By.partialLinkText("Phones & PDAs ("));
		this.vertCameras = driver.findElement(By.partialLinkText("Cameras ("));
		this.vertPlayers = driver.findElement(By.partialLinkText("MP3 Players ("));
	}
	
	// PageObject

	// get Data

	public WebElement getHome() {
		return this.home;
	}

	public WebElement getVertDesktops() {
		return this.vertDesktops;
	}

	public WebElement getVertDesktopsPc() {
		clickVertDesktops();
		return this.vertDesktopsMenu.vertPc;
	}

	public WebElement getVertDesktopsMac() {
		clickVertDesktops();
		return this.vertDesktopsMenu.vertMac;
	}

	public WebElement getVertLaptops() {
		return this.vertLaptops;
	}

	public WebElement getVertComponents() {
		return this.vertComponents;
	}

	public WebElement getVertTablets() {
		return this.vertTablets;
	}

	public WebElement getVertSoftware() {
		return this.vertSoftware;
	}

	public WebElement getVertPhones() {
		return this.vertPhones;
	}

	public WebElement getVertCameras() {
		return this.vertCameras;
	}

	public WebElement getVertPlayers() {
		return this.vertPlayers;
	}

	// Functional

	public String getVertDesktopsText() {
		return getVertDesktops().getText();
	}

	public String getVertDesktopsPcText() {
		return getVertDesktopsPc().getText();
	}

	public String getVertDesktopsMacText() {
		return getVertDesktopsMac().getText();
	}

	public String getVertLaptopsText() {
		return getVertLaptops().getText();
	}

	public String getVertComponentsText() {
		return getVertComponents().getText();
	}

	public String getVertTabletsText() {
		return getVertTablets().getText();
	}

	public String getVertSoftwareText() {
		return getVertSoftware().getText();
	}

	public String getVertPhonesText() {
		return getVertPhones().getText();
	}

	public String getVertCamerasText() {
		return getVertCameras().getText();
	}

	public String getVertPlayersText() {
		return getVertPlayers().getText();
	}

	// set Data

	public void clickHome() {
		getHome().click();
	}
	
	public void clickVertDesktops() {
		getVertDesktops().click();
		vertDesktopsMenu = new DesktopsAVerticalMenuPage();
	}

	public void clickVertDesktopsPc() {
		getVertDesktopsPc().click();
	}

	public void clickVertDesktopsMac() {
		getVertDesktopsMac().click();
	}

	public void clickVertLaptops() {
		getLaptops().click();
		// TODO
	}

	public void clickVertComponents() {
		getVertComponents().click();
		// TODO
	}

	public void clickVertTablets() {
		getVertTablets().click();
	}

	public void clickVertSoftware() {
		getVertSoftware().click();
	}

	public void clickVertPhones() {
		getVertPhones().click();
	}

	public void clickVertCameras() {
		getVertCameras().click();
	}

	public void clickVertPlayers() {
		getVertPlayers().click();
		// TODO
	}

	// Business Logic

}
