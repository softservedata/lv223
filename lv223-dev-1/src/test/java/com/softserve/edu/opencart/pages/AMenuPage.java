package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class AMenuPage extends ATopPage {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class DesktopsAMenuPage {
		public final WebElement pc;
		public final WebElement mac;
		public final WebElement allDesktops;

		public DesktopsAMenuPage() {
			/*-
    		this.pc = driver.findElement(By.partialLinkText("PC ("));
    		this.mac = driver.findElement(By.partialLinkText("Mac ("));
			*/
    		this.pc = driver.findElement(By.xpath("//div[@class='dropdown-inner']//li/a[contains(text(),'PC (')]"));
    		this.mac = driver.findElement(By.xpath("//div[@class='dropdown-inner']//li/a[contains(text(),'Mac (')]"));
    		this.allDesktops = driver.findElement(By.partialLinkText("Show All Desktops"));
    	}
	}

	private class PhonesAMenuPage {
		public final WebElement applePhones;
		public final WebElement htcPhones;
		public final WebElement otherPhones;
		public final WebElement samsungPhones;
		public final WebElement allPhones;
		
		public PhonesAMenuPage() {
			this.applePhones = driver.findElement(By.xpath("//nav[@id='menu']//a[contains(@href,'path=24_61')]"));
			this.htcPhones = driver.findElement(By.xpath("//nav[@id='menu']//a[contains(@href,'path=24_63')]"));
			this.otherPhones = driver.findElement(By.xpath("//nav[@id='menu']//a[contains(@href,'path=24_64')]"));
			this.samsungPhones = driver.findElement(By.xpath("//nav[@id='menu']//a[contains(@href,'path=24_62')]"));
			this.allPhones = driver.findElement(By.xpath("//*[contains(text(),'Show All Phones')]"));
		}
	}
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields
	
	// Horizontal Menu
	private WebElement desktops;
	private DesktopsAMenuPage desktopsMenu;
	private WebElement laptops;
	private WebElement components;
	private WebElement tablets;
	private WebElement software;
	private WebElement phones;
	private PhonesAMenuPage phonesMenu;
	private WebElement cameras;
	private WebElement players;

	protected AMenuPage(WebDriver driver) {
		super(driver);
		// if l10n exist
		/*-
		this.desktops = driver.findElement(By.xpath("//a[contains(@href,'path=20') and contains(@class,'dropdown-toggle')]"));
		this.laptops = driver.findElement(By.xpath("//a[contains(@href,'path=18') and contains(@class,'dropdown-toggle')]")); this.components = driver.findElement(By.xpath("//a[contains(@href,'path=25') and contains(@class,'dropdown-toggle')]"));
		this.tablets = driver.findElement(By.xpath("//a[contains(@href,'path=25') and contains(@class,'dropdown-toggle')]/parent::li/following-sibling::li[1]/a"));
		this.software = driver.findElement(By.xpath("//a[contains(@href,'path=25') and contains(@class,'dropdown-toggle')]/parent::li/following-sibling::li[2]/a"));
		this.phones = driver.findElement(By.xpath("//a[contains(@href,'path=25') and contains(@class,'dropdown-toggle')]/parent::li/following-sibling::li[3]/a"));
		this.cameras = driver.findElement(By.xpath("//a[contains(@href,'path=25') and contains(@class,'dropdown-toggle')]/parent::li/following-sibling::li[4]/a"));
		this.players = driver.findElement(By.xpath("//a[contains(@href,'path=34') and contains(@class,'dropdown-toggle')]"));
		*/
		//
		this.desktops = driver.findElement(By.linkText("Desktops"));
		this.laptops = driver.findElement(By.linkText("Laptops & Notebooks"));
		this.components = driver.findElement(By.linkText("Components"));
		this.tablets = driver.findElement(By.linkText("Tablets"));
		this.software = driver.findElement(By.linkText("Software"));
		this.phones = driver.findElement(By.linkText("Phones & PDAs"));
		this.cameras = driver.findElement(By.linkText("Cameras"));
		this.players = driver.findElement(By.linkText("MP3 Players"));
	}

	// PageObject

	// get Data

	public WebElement getDesktops() {
		return this.desktops;
	}

	public WebElement getDesktopsPc() {
		clickDesktops();
		return this.desktopsMenu.pc;
	}

	public WebElement getDesktopsMac() {
		clickDesktops();
		return this.desktopsMenu.mac;
	}

	public WebElement getDesktopsAll() {
		clickDesktops();
		return this.desktopsMenu.allDesktops;
	}

	public WebElement getLaptops() {
		return this.laptops;
	}

	public WebElement getComponents() {
		return this.components;
	}

	public WebElement getTablets() {
		return this.tablets;
	}

	public WebElement getSoftware() {
		return this.software;
	}

	public WebElement getPhones() {				//Phones
		return this.phones;				//Phones
	}

	public WebElement getApplePhones() {				//Phones
		clickPhones();											//Phones
		return this.phonesMenu.applePhones;					//Phones
	}
	
	public WebElement getHtcPhones() {				//Phones
		clickPhones();											//Phones
		return this.phonesMenu.htcPhones;					//Phones
	}
	
	public WebElement getOtherPhones() {				//Phones
		clickPhones();											//Phones
		return this.phonesMenu.otherPhones;					//Phones
	}
	
	public WebElement getSamsungPhones() {				//Phones
		clickPhones();											//Phones
		return this.phonesMenu.samsungPhones;					//Phones
	}
	
	public WebElement getAllPhones() {				//Phones
		clickPhones();											//Phones
		return this.phonesMenu.allPhones;					//Phones
	}
	
	public WebElement getCameras() {
		return this.cameras;
	}

	public WebElement getPlayers() {
		return this.players;
	}

	// Functional

	public String getDesktopsText() {
		return getDesktops().getText();
	}

	public String getLaptopsText() {
		return getLaptops().getText();
	}

	public String getComponentsText() {
		return getComponents().getText();
	}

	public String getTabletsText() {
		return getTablets().getText();
	}

	public String getSoftwareText() {
		return getSoftware().getText();
	}

	public String getPhonesText() {
		return getPhones().getText();
	}

	public String getCamerasText() {
		return getCameras().getText();
	}

	public String getPlayersText() {
		return getPlayers().getText();
	}

	// set Data

	public void clickDesktops() {
		getDesktops().click();
		desktopsMenu = new DesktopsAMenuPage();
	}

	public void clickDesktopsPc() {
		getDesktopsPc().click();
	}

	public void clickDesktopsMac() {
		getDesktopsMac().click();
	}

	public void clickDesktopsAll() {
		getDesktopsAll().click();
	}

	public void clickLaptops() {
		getLaptops().click();
		// TODO
	}

	public void clickComponents() {
		getComponents().click();
		// TODO
	}

	public void clickTablets() {
		getTablets().click();
	}

	public void clickSoftware() {
		getSoftware().click();
	}

	public void clickPhones() {				//Phones
		getPhones().click();				//Phones
		phonesMenu = new PhonesAMenuPage();				//Phones
	}

	public void clickPhonesApple() {				//Phones
		getApplePhones().click();				//Phones
	}
	
	public void clickPhonesHtc() {				//Phones
		getHtcPhones().click();				//Phones
	}
	
	public void clickPhonesOthers() {				//Phones
		getOtherPhones().click();				//Phones
	}
	public void clickPhonesSamsung() {				//Phones
		getSamsungPhones().click();				//Phones
	}
	public void clickPhonesAll() {				//Phones
		getAllPhones().click();					//Phones
	}
	
	public void clickCameras() {
		getCameras().click();
	}

	public void clickPlayers() {
		getPlayers().click();
		// TODO
	}

	// Business Logic

}
