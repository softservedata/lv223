package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.CountUtils;

public class VerticalMenuPage extends AProductListPage {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class DesktopsAVerticalMenuPage {
		public final WebElement vertPc;
		public final int vertPcCount;
		public final WebElement vertMac;
		public final int vertMacCount;

		public DesktopsAVerticalMenuPage() {
			this.vertPc = driver.findElement(By.partialLinkText("- PC ("));
			this.vertPcCount = CountUtils.getCountInBrackets(this.vertPc.getText());
			this.vertMac = driver.findElement(By.partialLinkText("- Mac ("));
			this.vertMacCount = CountUtils.getCountInBrackets(this.vertMac.getText());
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

	protected VerticalMenuPage(WebDriver driver, int column) {
		super(driver, column);
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

	private DesktopsAVerticalMenuPage getVertDesktopsMenu() {
		return this.vertDesktopsMenu;
	}

	public WebElement getVertDesktopsPc() {
		clickVertDesktops();
		return getVertDesktopsMenu().vertPc;
	}

	public int getVertPcCount() {
		if (getVertDesktopsMenu() == null) {
			clickVertDesktops();
		}
		return getVertDesktopsMenu().vertPcCount;
	}

	public WebElement getVertDesktopsMac() {
		clickVertDesktops();
		return getVertDesktopsMenu().vertMac;
	}

	public int getVertMacCount() {
		if (getVertDesktopsMenu() == null) {
			clickVertDesktops();
		}
		return getVertDesktopsMenu().vertMacCount;
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
	
	public HomePage gotoHome() {
		clickHome();
		return new HomePage(driver, HomePage.HOME_PRODUCT_COLUMN);
	}

	public VerticalMenuPage gotoVertDesktops() {
		clickVertDesktops();
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

	public VerticalMenuPage gotoVertDesktopsPc() {
		clickVertDesktopsPc();
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

	public VerticalMenuPage gotoVertDesktopsMac() {
		clickVertDesktopsMac();
		return new VerticalMenuPage(driver, 4);
	}

}
