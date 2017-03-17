package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.CountUtils;



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
        public final WebElement acer;
        public final WebElement allLaptops;

        public LaptopsAMenuPage() {
            this.apple = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=18_46')]"));
            this.hp = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=18_45')]"));
            this.others = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=18_72')]"));
            this.acer = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=18_71')]"));
            this.allLaptops = driver.findElement(By.partialLinkText("Show All Laptops"));
        }
    }

    // - - - - - - - - - COMPONENTS - - - - - - - - - - - - - - - - - -

    private class ComponentsAMenuPage {
        public final WebElement mice;
        //public final int miceCount;
        public final WebElement monitors;
        ///public final int monitorsCount;
        public final WebElement printers;
        //public final int printersCount;
        public final WebElement scanners;
        //public final int scannersCount;
        public final WebElement webCameras;
        //public final int webCamerasCount;
        public final WebElement allComponents;

        public ComponentsAMenuPage() {
            this.mice = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=25_29')]"));
            //this.miceCount= CountUtils.getCountInBrackets(getComponentsMice().getText());
            this.monitors = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=25_28')]"));
            //this.monitorsCount= CountUtils.getCountInBrackets(getComponentsMonitors().getText());
            this.printers = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=25_30')]"));
            //this.printersCount= CountUtils.getCountInBrackets(getComponentsPrinters().getText());
            this.scanners = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=25_31')]"));
            //this.scannersCount= CountUtils.getCountInBrackets(getComponentsScanners().getText());
            this.webCameras = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=25_32')]"));
            //this.webCamerasCount= CountUtils.getCountInBrackets(this.webCameras.getText());
            this.allComponents = driver.findElement(By.partialLinkText("Show All Components"));
        }

    }

    // - - - - - - - - - - - - - SOFTWARE - - - - - - - - - - - - - - - - -

    private class SoftwareAMenuPage {
        public final WebElement appleSoftware;
        public final WebElement microsoftSoftware;
        public final WebElement otherSoftware;
        public final WebElement allSoftware;

        public SoftwareAMenuPage() {
            this.appleSoftware = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=17_76')]"));
            this.microsoftSoftware = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=17_68')]"));
            this.otherSoftware = driver.findElement(By.xpath
                    ("//div[@class='dropdown-inner']//li/a[contains(@href,'&path=17_70')]"));
            this.allSoftware = driver.findElement(By.partialLinkText("Show All Laptops"));
        }
    }


    // - - - - - - - - - -PHONES - - - - - - - - - - -

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


    // - - - - - - - - - -CAMERAS - - - - - - - - - - -

    private class CamerasAMenuPage {
        public final WebElement canon;
        public final WebElement nikon;
        public final WebElement allCameras;

        public CamerasAMenuPage() {
            /*-
            this.pc = driver.findElement(By.partialLinkText("PC ("));
            this.mac = driver.findElement(By.partialLinkText("Mac ("));
            */
            this.canon = driver.findElement(By.xpath("//div[@class='dropdown-inner']//li/a[contains(text(),'Canon (')]"));
            this.nikon = driver.findElement(By.xpath("//div[@class='dropdown-inner']//li/a[contains(text(),'Nikon (')]"));
            this.allCameras = driver.findElement(By.partialLinkText("Show All Cameras"));
        }
    }


    // Fields

    public static final int MENU_PRODUCT_COLUMN = 4;
    //
    // Horizontal Menu
    private WebElement desktops;
    private DesktopsAMenuPage desktopsMenu;
    private WebElement laptops;
    private LaptopsAMenuPage laptopsMenu;
    private WebElement components;
    private ComponentsAMenuPage componentsMenu;
    private WebElement tablets;
    private WebElement software;
    private SoftwareAMenuPage softwareMenu;
    private WebElement phones;
    private PhonesAMenuPage phonesMenu;
    private WebElement cameras;
    private CamerasAMenuPage camerasMenu;
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

    public WebElement getLaptopsAcer() {
        clickLaptops();
        return this.laptopsMenu.acer;
    }

    public WebElement getLaptopsAll() {
        clickLaptops();
        return this.laptopsMenu.allLaptops;

    }

    //--------------COMPONENTS---------------------

    public WebElement getComponents() {
        return this.components;
    }

    public WebElement getComponentsMice() {
        clickComponents();
        return this.componentsMenu.mice;
    }

    public WebElement getComponentsMonitors() {
        clickComponents();
        return this.componentsMenu.monitors;
    }

    public WebElement getComponentsPrinters() {
        clickComponents();
        return this.componentsMenu.printers;
    }

    public WebElement getComponentsScanners() {
        clickComponents();
        return this.componentsMenu.scanners;
    }

    public WebElement getComponentsWebCameras() {
        clickComponents();
        return this.componentsMenu.webCameras;
    }

    public WebElement getComponentsAll(){
        clickComponents();
        return this.componentsMenu.allComponents;
    }
    //--------------------------------------------

    public WebElement getTablets() {
        return this.tablets;
    }

    // - - - - - - - - - - SOFTWARE - - - - - - - -

    public WebElement getSoftware() {
        return this.software;
    }

    public WebElement getAppleSoftware() {
        clickSoftware();
        return this.softwareMenu.appleSoftware;

    }

    public WebElement getMicrosoftSoftware() {
        clickSoftware();
        return this.softwareMenu.microsoftSoftware;

    }

    public WebElement getOtherSoftware() {
        clickSoftware();
        return this.softwareMenu.otherSoftware;
    }

    // - - - - - - - - PHONES - - - - - - - -

    public WebElement getPhones() {
        return this.phones;
    }

    public WebElement getApplePhones() {
        clickPhones();
        return this.phonesMenu.applePhones;
    }

    public WebElement getHtcPhones() {
        clickPhones();
        return this.phonesMenu.htcPhones;
    }

    public WebElement getOtherPhones() {
        clickPhones();
        return this.phonesMenu.otherPhones;
    }

    public WebElement getSamsungPhones() {
        clickPhones();
        return this.phonesMenu.samsungPhones;
    }

    public WebElement getAllPhones() {
        clickPhones();
        return this.phonesMenu.allPhones;
    }

    //-----------CAMERAS--------------------------------

    public WebElement getCameras() {
        return this.cameras;
    }
    public WebElement getCamerasCanon() {
        clickCameras();
        return this.camerasMenu.canon;
    }

    public WebElement getCamerasNikon() {
        clickCameras();
        return this.camerasMenu.nikon;
    }

    public WebElement getCamerasAll() {
        clickCameras();
        return this.camerasMenu.allCameras;
    }

    //--------------PLAYERS-----------------------

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

    //-------------------COMPONENTS-------------------???????????????????????---

    public String getComponentsText() {
        return getComponents().getText();
    }

    public String getComponentsMiceText() {
        return getComponentsMice().getText();
    }

    public String getComponentsMonitorsText() {
        return getComponentsMonitors().getText();
    }

    public String getComponentsPrintersText() {
        return getComponentsPrinters().getText();
    }

    public String getComponentsScannersText() {
        return getComponentsScanners().getText();
    }

    public String getComponentsWebCamerasText() {
        return getComponentsWebCameras().getText();
    }

    //---------------------------------------------------

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

    public void clickLaptopsAcer() {
        getLaptopsAcer().click();
    }

    //--------------------COMPONENTS---------------------

    public void clickComponents() {
        getComponents().click();
        componentsMenu = new ComponentsAMenuPage();
    }

    public void clickComponentsMice() {
        getComponentsMice().click();
    }

    public void clickComponentsMonitors() {
        getComponentsMonitors().click();
    }

    public void clickComponentsPrinters() {
        getComponentsPrinters().click();
    }

    public void clickComponentsScanners() {
        getComponentsScanners().click();
    }

    public void clickComponentsWebCameras() {
        getComponentsWebCameras().click();
    }

    public void clickComponentsAll() {
        getComponentsAll().click();
    }

    //---------------------------------------------------

    public void clickTablets() {
        getTablets().click();
    }

    // - -  - - - - - - SOFTWARE - - - - - - - 

    public void clickSoftware() {
        getSoftware().click();
        softwareMenu = new SoftwareAMenuPage();
    }

    public void clickAppleSoftware() {
        getAppleSoftware().click();
    }

    public void clickMicrosoftSoftware() {
        getMicrosoftSoftware().click();
    }

    public void clickOtherSoftware() {
        getOtherSoftware().click();
    }

    //--------------PHONES------------------------------

    public void clickPhones() {
        getPhones().click();
        phonesMenu = new PhonesAMenuPage();
    }

    public void clickPhonesApple() {
        getApplePhones().click();
    }

    public void clickPhonesHtc() {
        getHtcPhones().click();
    }

    public void clickPhonesOthers() {
        getOtherPhones().click();
    }
    public void clickPhonesSamsung() {
        getSamsungPhones().click();
    }
    public void clickPhonesAll() {
        getAllPhones().click();
    }

    //--------------CAMERAS------------------------------

    public void clickCameras() {
        getCameras().click();
        camerasMenu = new CamerasAMenuPage();
    }

    public void clickCamerasCanon() {
        getCamerasCanon().click();
    }

    public void clickCamerasNikon() {
        getCamerasNikon().click();
    }

    public void clickCamerasAll() {
        getCamerasAll().click();
    }

    //--------------PLAYER----------------------------------------------
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

    //-------------------COMPONENTS--------------------

    public VerticalMenuPage gotoComponentsAll() {
        clickComponentsAll();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoComponentsMice() {
        clickComponentsMice();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoComponentsMonitors() {
        clickComponentsMonitors();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoComponentsPrinters() {
        clickComponentsPrinters();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoComponentsScanners() {
        clickComponentsScanners();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoComponentsWebCameras() {
        clickComponentsWebCameras();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }


    // - - - - - - - - - -PHONES - - - - - - - - - - -

    public VerticalMenuPage gotoPhonesApple() {
        clickPhonesApple();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoPhonesHtc() {
        clickPhonesHtc();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoPhonesOthers() {
        clickPhonesOthers();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoPhonesSamsung() {
        clickPhonesSamsung();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

    public VerticalMenuPage gotoPhonesAll() {
        clickPhonesAll();
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }

}

