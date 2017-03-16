package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.CountUtils;

public class VerticalMenuPage extends AProductListPage {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -

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

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -

    private class LaptopsAVerticalMenuPage {
        public final WebElement vertApple;
        public final int vertAppleCount;
        public final WebElement vertHp;
        public final int vertHpCount;
        public final WebElement vertOthers;
        public final int vertOthersCount;
        public final WebElement vertAcer;
        public final int vertAcerCount;

        public LaptopsAVerticalMenuPage() {
            this.vertApple = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Apple (')]"));
            this.vertAppleCount = CountUtils.getCountInBrackets(this.vertApple.getText());
            this.vertHp = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'HP (')]"));
            this.vertHpCount = CountUtils.getCountInBrackets(this.vertHp.getText());
            this.vertOthers = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Others (')]"));
            this.vertOthersCount = CountUtils.getCountInBrackets(this.vertOthers.getText());
            this.vertAcer = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Acer (')]"));
            this.vertAcerCount = CountUtils.getCountInBrackets(this.vertAcer.getText());
        }
    }

    //- - - - - - - - - - - -SOFTWARE - - -  - - - -
    private class SoftwareAVerticalMenuPage {
        public final WebElement vertAppleSoftware;
        public final int vertAppleSoftwareCount;
        public final WebElement vertMicrosoftSoftware;
        public final int vertMicrosoftSoftwareCount;
        public final WebElement vertOtherSoftware;
        public final int vertOtherSoftwareCount;

        public SoftwareAVerticalMenuPage() {
            this.vertAppleSoftware = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(@href,'&path=17_76')]"));
            this.vertAppleSoftwareCount = CountUtils.getCountInBrackets(this.vertAppleSoftware.getText());
            this.vertMicrosoftSoftware = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(@href,'&path=17_68')]"));
            this.vertMicrosoftSoftwareCount = CountUtils.getCountInBrackets(this.vertMicrosoftSoftware.getText());
            this.vertOtherSoftware = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(@href,'&path=17_70')]"));
            this.vertOtherSoftwareCount = CountUtils.getCountInBrackets(this.vertOtherSoftware.getText());
        }
    }

    //----------------------COMPONENTS---------------------------

    private class ComponentsAVerticalMenuPage {
        public final WebElement vertMice;
        public final int vertMiceCount;
        public final WebElement vertMonitors;
        public final int vertMonitorsCount;
        public final WebElement vertPrinters;
        public final int vertPrintersCount;
        public final WebElement vertScanners;
        public final int vertScannersCount;
        public final WebElement vertWebCameras;
        public final int vertWebCamerasCount;

        public ComponentsAVerticalMenuPage() {
            this.vertMice = driver.findElement(By.partialLinkText("- Mice and Trackballs ("));
            this.vertMiceCount = CountUtils.getCountInBrackets(this.vertMice.getText());
            this.vertMonitors = driver.findElement(By.partialLinkText("- Monitors ("));
            this.vertMonitorsCount = CountUtils.getCountInBrackets(this.vertMonitors.getText());
            this.vertPrinters = driver.findElement(By.partialLinkText("- Printers ("));
            this.vertPrintersCount = CountUtils.getCountInBrackets(this.vertPrinters.getText());
            this.vertScanners = driver.findElement(By.partialLinkText("- Scanners ("));
            this.vertScannersCount = CountUtils.getCountInBrackets(this.vertScanners.getText());
            this.vertWebCameras = driver.findElement(By.partialLinkText("- Web Cameras ("));
            this.vertWebCamerasCount = CountUtils.getCountInBrackets(this.vertWebCameras.getText());
        }
    }

    // Fields

    private WebElement home;
    //
    // Vertical Menu
    private WebElement vertDesktops;
    private DesktopsAVerticalMenuPage vertDesktopsMenu;
    private WebElement vertLaptops;
    private LaptopsAVerticalMenuPage vertLaptopsMenu;
    private WebElement vertComponents;
    private ComponentsAVerticalMenuPage vertComponentsMenu;
    private WebElement vertTablets;
    private WebElement vertSoftware;
    private SoftwareAVerticalMenuPage vertSoftwareMenu;
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

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -

    public WebElement getVertDesktops() {
        return this.vertDesktops;
    }

    private DesktopsAVerticalMenuPage getVertDesktopsMenu() {
        this.vertDesktopsMenu = new DesktopsAVerticalMenuPage();
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

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -

    public WebElement getVertLaptops() {
        return this.vertLaptops;
    }

    private LaptopsAVerticalMenuPage getVertLaptopsMenu() {
        this.vertLaptopsMenu = new LaptopsAVerticalMenuPage();
        return this.vertLaptopsMenu;
    }

    public WebElement getVertLaptopsApple() {
        clickVertLaptops();
        return getVertLaptopsMenu().vertApple;
    }

    public int getVertLaptopsAppleCount() {
        if (getVertLaptopsMenu() == null) {
            clickVertLaptops();
        }
        return getVertLaptopsMenu().vertAppleCount;
    }

    public WebElement getVertLaptopsHp() {
        clickVertLaptops();
        return getVertLaptopsMenu().vertHp;
    }

    public int getVertLaptopsHpCount() {
        if (getVertLaptopsMenu() == null) {
            clickVertLaptops();
        }
        return getVertLaptopsMenu().vertHpCount;
    }

    public WebElement getVertLaptopsAcer() {
        clickVertLaptops();
        return getVertLaptopsMenu().vertAcer;
    }

    public int getVertLaptopsAcerCount() {
        if (getVertLaptopsMenu() == null) {
            clickVertLaptops();
        }
        return getVertLaptopsMenu().vertAcerCount;
    }

    public WebElement getVertLaptopsOthers() {
        clickVertLaptops();
        return getVertLaptopsMenu().vertOthers;
    }

    public int getVertLaptopsOthersCount() {
        if (getVertLaptopsMenu() == null) {
            clickVertLaptops();
        }
        return getVertLaptopsMenu().vertOthersCount;
    }

    //------------------------COMPONENTS----------------------------

    public WebElement getVertComponents() {
        return this.vertComponents;
    }

    public ComponentsAVerticalMenuPage getVertComponentsMenu() {
        this.vertComponentsMenu = new ComponentsAVerticalMenuPage();
        return this.vertComponentsMenu;
    }

    public WebElement getVertComponentsMice() {
        return this.getVertComponentsMenu().vertMice;
    }

    public int getVertComponentsMiceCount() {
        if (getVertComponentsMenu() == null) {
            clickVertComponents();
        }
        return getVertComponentsMenu().vertMiceCount;
    }

    public WebElement getVertComponentsMonitors() {
        return this.getVertComponentsMenu().vertMonitors;
    }

    public int getVertComponentsMonitorsCount() {
        if (getVertComponentsMenu() == null) {
            clickVertComponents();
        }
        return getVertComponentsMenu().vertMonitorsCount;
    }


    public WebElement getVertComponentsPrinters() {
        return this.getVertComponentsMenu().vertPrinters;
    }

    public int getVertComponentsPrintersCount() {
        if (getVertComponentsMenu() == null) {
            clickVertComponents();
        }
        return getVertComponentsMenu().vertPrintersCount;
    }


    public WebElement getVertComponentsScanners() {
        return this.getVertComponentsMenu().vertScanners;
    }

    public int getVertComponentsScannersCount() {
        if (getVertComponentsMenu() == null) {
            clickVertComponents();
        }
        return getVertComponentsMenu().vertScannersCount;
    }

    public WebElement getVertComponentsWebCameras() {
        return this.getVertComponentsMenu().vertWebCameras;
    }

    public int getVertComponentsWebCamerasCount() {
        if (getVertComponentsMenu() == null) {
            clickVertComponents();
        }
        return getVertComponentsMenu().vertWebCamerasCount;
    }

    //---------------------------------------------------------------

    public WebElement getVertTablets() {
        return this.vertTablets;
    }

    // - - -  - -  - - - SOFTWARE - - -  - -  - - - -
    public WebElement getVertSoftware() {
        return this.vertSoftware;
    }

    public SoftwareAVerticalMenuPage getVertSoftwareMenu() {
        return this.vertSoftwareMenu;
    }

    public WebElement getVertAppleSoftware() {
        clickVertSoftware();
        return getVertSoftwareMenu().vertAppleSoftware;
    }

    public int getVertAppleSoftwareCount() {
        if (getVertSoftwareMenu() == null) {
            clickVertSoftware();
        }
        return getVertSoftwareMenu().vertAppleSoftwareCount;
    }

    public WebElement getVertMicrosoftSoftware() {
        clickVertSoftware();
        return getVertSoftwareMenu().vertMicrosoftSoftware;
    }

    public int getVertMicrosoftSoftwareCount() {
        if (getVertSoftwareMenu() == null) {
            clickVertSoftware();
        }
        return getVertSoftwareMenu().vertMicrosoftSoftwareCount;
    }

    public WebElement getVertOtherSoftware() {
        clickVertSoftware();
        return getVertSoftwareMenu().vertOtherSoftware;
    }

    public int getVertOtherSoftwareCount() {
        if (getVertSoftwareMenu() == null) {
            clickVertSoftware();
        }
        return getVertSoftwareMenu().vertOtherSoftwareCount;
    }
    //- - - - - -  - - - - -  - - - - - -  - - - - - -  -  

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

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -


    public String getVertDesktopsText() {
        return getVertDesktops().getText();
    }

    public String getVertDesktopsPcText() {
        return getVertDesktopsPc().getText();
    }

    public String getVertDesktopsMacText() {
        return getVertDesktopsMac().getText();
    }

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -

    public String getVertLaptopsText() {
        return getVertLaptops().getText();
    }

    public String getVertLaptopsAppleText() {
        return getVertLaptopsApple().getText();
    }

    public String getVertLaptopsHpText() {
        return getVertLaptopsHp().getText();
    }

    public String getVertLaptopsAcerText() {
        return getVertLaptopsAcer().getText();
    }

    public String getVertLaptopsOthersText() {
        return getVertLaptopsOthers().getText();
    }

    //----------------------------COMPONENTS------------------

    public String getVertComponentsText() {
        return getVertComponents().getText();
    }

    public String getVertComponentsMiceText() {
        return getVertComponentsMice().getText();
    }

    public String getVertComponentsMonitorsText() {
        return getVertComponentsMonitors().getText();
    }

    public String getVertComponentsPrintersText() {
        return getVertComponentsPrinters().getText();
    }

    public String getVertComponentsScannersText() {
        return getVertComponentsScanners().getText();
    }

    public String getVertComponentsWebCamerasText() {
        return getVertComponentsWebCameras().getText();
    }

    //--------------------------------------------------------

    public String getVertTabletsText() {
        return getVertTablets().getText();
    }

// - - - - - - - - - SOFTWARE - - - - - - - - - - 

    public String getVertSoftwareText() {
        return getVertSoftware().getText();
    }

    public String getVertSoftwareAppleText() {
        return getVertAppleSoftware().getText();
    }

    public String getVertMicrosoftSoftwareText() {
        return getVertMicrosoftSoftware().getText();
    }

    public String getVertOtherSoftwareText() {
        return getVertOtherSoftware().getText();
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

    // - - - - - - - - - -DESKTOPS - - - - - - - - - - -

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

    // - - - - - - - - - -LAPTOPS - - - - - - - - - - -

    public void clickVertLaptops() {
        getLaptops().click();
    }

    public void clickVertLaptopsApple() {
        getVertLaptopsApple().click();
    }

    public void clickVertLaptopsHp() {
        getVertLaptopsHp().click();
    }

    public void clickVertLaptopsAcer() {
        getVertLaptopsAcer().click();
    }

    public void clickVertLaptopsOthers() {
        getVertLaptopsOthers().click();
    }

    //--------------------------COMPONENTS---------------------

    public void clickVertComponents() {
        getVertComponents().click();
    }

    public void clickVertComponentsMice() {
        getVertComponentsMice().click();
    }

    public void clickVertComponentsMonitors() {
        getVertComponentsMonitors().click();
    }

    public void clickVertComponentsPrinters() {
        getVertComponentsPrinters().click();
    }

    public void clickVertComponentsScanners() {
        getVertComponentsScanners().click();
    }

    public void clickVertComponentsWebCameras() {
        getVertComponentsWebCameras().click();
    }

    //---------------------------------------------------------

    public void clickVertTablets() {
        getVertTablets().click();
    }

    //- - - - - - - - - - - - SOFTWARE - - - - - - - - -
    public void clickVertSoftware() {
        getVertSoftware().click();
    }

    public void clickVertAppleSoftware() {
        getVertAppleSoftware().click();
    }

    public void clickVertMicrosoftSoftware() {
        getVertMicrosoftSoftware().click();
    }

    public void clickVertOtherSoftware() {
        getVertOtherSoftware().click();
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
        return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
    }


}