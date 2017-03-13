package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.CountUtils;

abstract class AVerticalMenuPage extends AMenuPage {

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

	
	private class PhonesAVerticalMenuPage{				//Phones
		public final WebElement vertApplePhones;				//Phones
		public final int vertApplePhonesCount;				//Phones
		public final WebElement vertHtcPhones;				//Phones
		public final int vertHtcPhonesCount;				//Phones
		public final WebElement vertOthersPhones;				//Phones
		public final int vertOthersPhonesCount;				//Phones
		public final WebElement vertSamsungPhones;				//Phones
		public final int vertSamsungPhonesCount;				//Phones
		
		public PhonesAVerticalMenuPage() {				//Phones				 
			this.vertApplePhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Apple (')]"));					//Phones		
			this.vertApplePhonesCount = CountUtils.getCountInBrackets(this.vertApplePhones.getText());							//Phones
			this.vertHtcPhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'HTC (')]"));						//Phones			
			this.vertHtcPhonesCount = CountUtils.getCountInBrackets(this.vertHtcPhones.getText());
			this.vertOthersPhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Others (')]"));				//Phones	
			this.vertOthersPhonesCount = CountUtils.getCountInBrackets(this.vertOthersPhones.getText());
			this.vertSamsungPhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Samsung (')]"));				//Phones
			this.vertSamsungPhonesCount = CountUtils.getCountInBrackets(this.vertSamsungPhones.getText());										//Phones
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
	private PhonesAVerticalMenuPage vertPhonesMenu;				//Phones
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

	public DesktopsAVerticalMenuPage getVertDesktopsMenu() {
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
	
	public PhonesAVerticalMenuPage getVertPhonesMenu() {			//Phones
		return this.vertPhonesMenu;									//Phones
	}

	public WebElement getVertApplePhones() {							//Phones
		clickVertPhones();												//Phones
		return getVertPhonesMenu().vertApplePhones;						//Phones
	}

	public int getVertApplePhonesCount() {					//Phones
		if (getVertPhonesMenu() == null) {					//Phones
			clickVertPhones();					//Phones
		}
		return getVertPhonesMenu().vertApplePhonesCount;					//Phones
	}
	
	public WebElement getVertHtcPhones() {							//Phones
		clickVertPhones();											//Phones
		return getVertPhonesMenu().vertHtcPhones;					//Phones
	}
	
	public int getVertHtcPhonesCount() {					//Phones
		if (getVertPhonesMenu() == null) {					//Phones
			clickVertPhones();								//Phones
		}
		return getVertPhonesMenu().vertHtcPhonesCount;					//Phones
	}
	
	public WebElement getVertOthersPhones() {							//Phones
		clickVertPhones();												//Phones
		return getVertPhonesMenu().vertOthersPhones;					//Phones
	}
	
	public int getVertOthersPhonesCount() {					//Phones
		if (getVertPhonesMenu() == null) {					//Phones
			clickVertPhones();
		}
		return getVertPhonesMenu().vertOthersPhonesCount;					//Phones
	}
	
	public WebElement getVertSamsungPhones() {							//Phones
		clickVertPhones();												//Phones
		return getVertPhonesMenu().vertSamsungPhones;					//Phones
	}
	
	public int getVertSamsungPhonesCount() {					//Phones
		if (getVertPhonesMenu() == null) {					//Phones
			clickVertPhones();								//Phones
		}
		return getVertPhonesMenu().vertSamsungPhonesCount;				//Phones
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

	public String getVertPhonesText() {				//Phones
		return getVertPhones().getText();				//Phones
	}
	
	public String getVertPhonesAppleText() {				//Phones
		return getVertApplePhones().getText();					//Phones
	}
	
	public String getVertPhonesHtcText() {				//Phones
		return getVertHtcPhones().getText(); 					//Phones
	}
	
	public String getVertPhonesOthersText() {				//Phones
		return getVertOthersPhones().getText();					//Phones
	}
	
	public String getVertPhonesSamsungText() {				//Phones
		return getVertSamsungPhones().getText(); 					//Phones
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

	public void clickVertPhones() {				//Phones
		getVertPhones().click();				//Phones
		vertPhonesMenu = new PhonesAVerticalMenuPage();				//Phones
	}

	public void clickVertPnonesApple() {				//Phones
		getVertApplePhones().click();				//Phones
	}
	
	public void clickVertPhonesHtc() {				//Phones
		getVertHtcPhones().click();				//Phones
	}
	
	public void clickVertPhonesOthers() {				//Phones
		getVertOthersPhones().click();				//Phones
	}
	
	public void clickVertPhonesSamsung() {				//Phones
		getVertSamsungPhones().click();				//Phones
	}
	
	public void clickVertCameras() {
		getVertCameras().click();
	}

	public void clickVertPlayers() {
		getVertPlayers().click();
		// TODO
	}

	// Business Logic

	public ProductListPage gotoVertDesktops() {
		clickVertDesktops();
		return new ProductListPage(driver,
				driver.findElements(By.cssSelector("div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12")));
	}

}
