package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class AMenuPage extends ATopPage {

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -

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

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -

    private class LaptopsAMenuPage {
        public final WebElement apple;
        public final WebElement hp;
        public final WebElement others;
        public final WebElement samsung;
        public final WebElement allLaptops;

        public LaptopsAMenuPage() {
            this.apple = driver.findElement(By.xpath
                    ("(//div[@class='dropdown-inner']//li/a[contains(text(),'Apple (')])[1]"));
            this.hp = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(text(),'HP (')]"));
            this.others = driver.findElement(By.xpath
                    ("(//div[@class='dropdown-inner']//li/a[contains(text(),'Others (')])[1]"));
            this.samsung = driver.findElement(By.xpath
                    ("(//div[@class='dropdown-inner']//li/a[contains(text(),'Samsung (')])[1]"));
            this.allLaptops = driver.findElement(By.partialLinkText("Show All Laptops"));
        }
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Fields

    public static final int MENU_PRODUCT_COLUMN = 4;
    //
    // Horizontal Menu
    private WebElement desktops;
    private DesktopsAMenuPage desktopsMenu;
    private WebElement laptops;
    private LaptopsAMenuPage laptopsMenu;
    private WebElement components;
    private WebElement tablets;
    private WebElement software;
    private WebElement phones;
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

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -

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

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -

    public WebElement getLaptops() {
        return this.laptops;
    }

    public WebElement getLaptopsApple() {
        clickLaptops();
        return this.laptopsMenu.apple;

    }

    public WebElement getLaptopsHp() {
        clickLaptops();
        return this.laptopsMenu.hp;

    }

    public WebElement getLaptopsOthers() {
        clickLaptops();
        return this.laptopsMenu.others;

    }

    public WebElement getLaptopsSamsung() {
        clickLaptops();
        return this.laptopsMenu.samsung;

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

    public WebElement getPhones() {
        return this.phones;
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

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -

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

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -

    public void clickLaptops() {
        getLaptops().click();
        laptopsMenu = new LaptopsAMenuPage();
    }

    public void clickLaptopsApple() {
        getLaptopsApple().click();
    }

    public void clickLaptopsHp() {
        getLaptopsHp().click();
    }

    public void clickLaptopsOthers() {
        getLaptopsOthers().click();
    }

    public void clickLaptopsSamsung() {
        getLaptopsSamsung().click();
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

    public void clickPhones() {
        getPhones().click();
    }

    public void clickCameras() {
        getCameras().click();
    }

    public void clickPlayers() {
        getPlayers().click();
        // TODO
    }

    // Business Logic

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -

    public VerticalMenuPage gotoDesktopsAll() {
        clickDesktopsAll();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoDesktopsPc() {
        clickDesktopsPc();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoDesktopsMac() {
        clickDesktopsMac();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -


}
