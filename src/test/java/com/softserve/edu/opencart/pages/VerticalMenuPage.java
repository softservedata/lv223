package com.softserve.edu.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.CountUtils;
import com.softserve.edu.opencart.tools.GeneralException;

public class VerticalMenuPage extends AProductListPage {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class VertMenuPage {
		private static final String CATEGORY_VERT_PARTIALLINKTEXT = "%s (";
		private static final String SUBCATEGORY_LIST_XPATH = "//div[@class='list-group']//a[contains(@href,'&path=%s_')]";
		//
		// Fields
		private final CategoryRepository category;
		private WebElement categoryVert;
		private List<WebElement> subCategoryVert;

		public VertMenuPage(CategoryRepository category) {
			this.category = category;
			this.categoryVert = driver.findElement(By.partialLinkText(
					String.format(CATEGORY_VERT_PARTIALLINKTEXT, category.getCategory())));
		}

		// PageObject

		private void initSubCategories() {
			clickCategoryVert();
			this.subCategoryVert = driver
					.findElements(By.xpath(String.format(SUBCATEGORY_LIST_XPATH, category.getIdPath())));
		}

		// get Data

		public CategoryRepository getCategory() {
			return this.category;
		}

		public WebElement getCategoryVert() {
			return this.categoryVert;
		}

		public List<WebElement> getSubCategoryVerts() {
			initSubCategories();
			return this.subCategoryVert;
		}

		public WebElement getSubCategoryVert(String subCategory) {
			WebElement resultWebElement = null;
			for (WebElement currentWebElement : getSubCategoryVerts()) {
				if (currentWebElement.getText().trim().toLowerCase().contains(subCategory.trim().toLowerCase())) {
					resultWebElement = currentWebElement;
					break;
				}
			}
			if (resultWebElement == null) {
				throw new GeneralException(SUBCATEGORY_NOT_FOUND_ERROR_MESSAGE);
			}
			return resultWebElement;
		}

		public int getCategoryVertCount() {
			return CountUtils.getCountInBrackets(getCategoryVertText());
		}

		public int getSubCategoryVertCount(int index) {
			return CountUtils.getCountInBrackets(getSubCategoryVertText(index));
		}

		public int getSubCategoryVertCount(String subCategory) {
			return CountUtils.getCountInBrackets(getSubCategoryVertText(subCategory));
		}
		
		// Functional

		public String getCategoryVertText() {
			return getCategoryVert().getText();
		}

		public List<String> getSubCategoryVertTexts() {
			List<String> subCategories = new ArrayList<String>();
			for (WebElement currentWebElement : getSubCategoryVerts()) {
				subCategories.add(currentWebElement.getText());
			}
			return subCategories;
		}

		public String getSubCategoryVertText(int index) {
			return getSubCategoryVertTexts().get(index);
		}

		public String getSubCategoryVertText(String subCategory) {
			return getSubCategoryVert(subCategory).getText();
		}

		// set Data

		public void clickCategoryVert() {
			getCategoryVert().click();
		}

		public void clickSubCategoryVert(int index) {
			getSubCategoryVerts().get(index).click();
		}

		public void clickSubCategoryVert(String subCategory) {
			getSubCategoryVert(subCategory).click();
		}
	}

	/*
	//  +++++DELETE+++++++++++++++++++++++++
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
        //public final int vertMiceCount;
        public final WebElement vertMonitors;
        //public final int vertMonitorsCount;
        public final WebElement vertPrinters;
        //public final int vertPrintersCount;
        public final WebElement vertScanners;
        //public final int vertScannersCount;
        public final WebElement vertWebCameras;
        //public final int vertWebCamerasCount;

        public ComponentsAVerticalMenuPage() {
            this.vertMice = driver.findElement(By.partialLinkText("- Mice and Trackballs ("));
            //this.vertMiceCount = CountUtils.getCountInBrackets(this.vertMice.getText());
            this.vertMonitors = driver.findElement(By.partialLinkText("- Monitors ("));
            //this.vertMonitorsCount = CountUtils.getCountInBrackets(this.vertMonitors.getText());
            this.vertPrinters = driver.findElement(By.partialLinkText("- Printers ("));
            //this.vertPrintersCount = CountUtils.getCountInBrackets(this.vertPrinters.getText());
            this.vertScanners = driver.findElement(By.partialLinkText("- Scanners ("));
            //this.vertScannersCount = CountUtils.getCountInBrackets(this.vertScanners.getText());
            this.vertWebCameras = driver.findElement(By.partialLinkText("- Web Cameras ("));
            //this.vertWebCamerasCount = CountUtils.getCountInBrackets(this.vertWebCameras.getText());
        }
    }

    // - - - - - - - - - -PHONES - - - - - - - - - - -

    private class PhonesAVerticalMenuPage{
        public final WebElement vertApplePhones;
        public final int vertApplePhonesCount;
        public final WebElement vertHtcPhones;
        public final int vertHtcPhonesCount;
        public final WebElement vertOthersPhones;
        public final int vertOthersPhonesCount;
        public final WebElement vertSamsungPhones;
        public final int vertSamsungPhonesCount;

        public PhonesAVerticalMenuPage() {
            this.vertApplePhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Apple (')]"));
            this.vertApplePhonesCount = CountUtils.getCountInBrackets(this.vertApplePhones.getText());
            this.vertHtcPhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'HTC (')]"));
            this.vertHtcPhonesCount = CountUtils.getCountInBrackets(this.vertHtcPhones.getText());
            this.vertOthersPhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Others (')]"));
            this.vertOthersPhonesCount = CountUtils.getCountInBrackets(this.vertOthersPhones.getText());
            this.vertSamsungPhones = driver.findElement(By.xpath("//div[@class='list-group']//a[contains(text(),'Samsung (')]"));
            this.vertSamsungPhonesCount = CountUtils.getCountInBrackets(this.vertSamsungPhones.getText());
        }
    }

    // - - - - - - - - - -CAMERAS - - - - - - - - - - -

    private class CamerasAVerticalMenuPage {
        public final WebElement vertCanon;
        public final int vertCanonCount;
        public final WebElement vertNikon;
        public final int vertNikonCount;

        public CamerasAVerticalMenuPage() {
            this.vertCanon = driver.findElement(By.partialLinkText("- Canon ("));
            this.vertCanonCount = CountUtils.getCountInBrackets(this.vertCanon.getText());
            this.vertNikon = driver.findElement(By.partialLinkText("- Nikon ("));
            this.vertNikonCount = CountUtils.getCountInBrackets(this.vertNikon.getText());
        }
    }

    // +++++++++++++++++++++++++++++++++++++++++++
	*/
    
    
    
    
    // Fields

    private WebElement home;
	// Vertical Menu
	private List<VertMenuPage> verticalMenu;

    /*
    // Vertical Menu
    // ++++DELETE++++++++
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
    private PhonesAVerticalMenuPage vertPhonesMenu;
    private WebElement vertCameras;
    private CamerasAVerticalMenuPage vertCamerasMenu;
    private WebElement vertPlayers;
    //+++++++++++++++++++
	*/
	
    protected VerticalMenuPage(WebDriver driver, int column) {
        super(driver, column);
        initVerticalMenu();
        
        /*
        //+DEELETE++++++++++++++++++++
        this.vertDesktops = driver.findElement(By.partialLinkText("Desktops ("));
        this.vertLaptops = driver.findElement(By.partialLinkText("Laptops & Notebooks ("));
        this.vertComponents = driver.findElement(By.partialLinkText("Components ("));
        this.vertTablets = driver.findElement(By.partialLinkText("Tablets ("));
        this.vertSoftware = driver.findElement(By.partialLinkText("Software ("));
        this.vertPhones = driver.findElement(By.partialLinkText("Phones & PDAs ("));
        this.vertCameras = driver.findElement(By.partialLinkText("Cameras ("));
        this.vertPlayers = driver.findElement(By.partialLinkText("MP3 Players ("));
        //+++++++++++++++++++
         */
    }

    // PageObject

	private void initVerticalMenu() {
		verticalMenu = new ArrayList<VertMenuPage>();
		for (CategoryRepository currentCategory : CategoryRepository.values()) {
			verticalMenu.add(new VertMenuPage(currentCategory));
		}
	}

	private VertMenuPage getVertMenuPage(CategoryRepository category) {
		VertMenuPage vertMenuPage = null;
		for (VertMenuPage currentVertMenu : verticalMenu) {
			if (currentVertMenu.getCategory() == category) {
				vertMenuPage = currentVertMenu;
				break;
			}
		}
		if (vertMenuPage == null) {
			throw new GeneralException(SUBCATEGORY_NOT_FOUND_ERROR_MESSAGE);
		}
		return vertMenuPage;
	}

    // get Data

    public WebElement getHome() {
        return this.home;
    }

	public WebElement getVerticalMenuCategory(CategoryRepository category) {
		return getVertMenuPage(category).getCategoryVert();
	}

	public WebElement getVerticalMenuSubCategory(CategoryRepository category, int index) {
		return getVertMenuPage(category).getSubCategoryVerts().get(index);
	}

	public WebElement getVerticalMenuSubCategory(CategoryRepository category, String subCategory) {
		return getVertMenuPage(category).getSubCategoryVert(subCategory);
	}

	public int getVerticalMenuCategoryCount(CategoryRepository category) {
		return getVertMenuPage(category).getCategoryVertCount();
	}

	public int getVerticalMenuSubCategoryCount(CategoryRepository category, int index) {
		return getVertMenuPage(category).getSubCategoryVertCount(index);
	}

	public int getVerticalMenuSubCategoryCount(CategoryRepository category, String subCategory) {
		return getVertMenuPage(category).getSubCategoryVertCount(subCategory);
	}

	/*
    //+++++++++DELETE+++++++++++++
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

    public WebElement getVertComponentsMonitors() {
        return this.getVertComponentsMenu().vertMonitors;
    }


    public WebElement getVertComponentsPrinters() {
        return this.getVertComponentsMenu().vertPrinters;
    }


    public WebElement getVertComponentsScanners() {
        return this.getVertComponentsMenu().vertScanners;
    }

    public WebElement getVertComponentsWebCameras() {
        return this.getVertComponentsMenu().vertWebCameras;
    }


    // - - - - - - - - -TABLETS - - - - - - - - - -

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

    // - - - - - - - - -PHONES - - - - - - - - - -

    public WebElement getVertPhones() {
        return this.vertPhones;
    }

    public PhonesAVerticalMenuPage getVertPhonesMenu() {
        return this.vertPhonesMenu;
    }

    public WebElement getVertApplePhones() {
        clickVertPhones();
        return getVertPhonesMenu().vertApplePhones;
    }

    public int getVertApplePhonesCount() {
        if (getVertPhonesMenu() == null) {
            clickVertPhones();
        }
        return getVertPhonesMenu().vertApplePhonesCount;
    }

    public WebElement getVertHtcPhones() {
        clickVertPhones();
        return getVertPhonesMenu().vertHtcPhones;
    }

    public int getVertHtcPhonesCount() {
        if (getVertPhonesMenu() == null) {
            clickVertPhones();
        }
        return getVertPhonesMenu().vertHtcPhonesCount;
    }

    public WebElement getVertOthersPhones() {
        clickVertPhones();
        return getVertPhonesMenu().vertOthersPhones;
    }

    public int getVertOthersPhonesCount() {
        if (getVertPhonesMenu() == null) {
            clickVertPhones();
        }
        return getVertPhonesMenu().vertOthersPhonesCount;
    }

    public WebElement getVertSamsungPhones() {
        clickVertPhones();
        return getVertPhonesMenu().vertSamsungPhones;
    }

    public int getVertSamsungPhonesCount() {
        if (getVertPhonesMenu() == null) {
            clickVertPhones();
        }
        return getVertPhonesMenu().vertSamsungPhonesCount;
    }

    // - - - - - - - - -CAMERAS - - - - - - - - - -

    public WebElement getVertCameras() {
        return this.vertCameras;
    }

    public CamerasAVerticalMenuPage getVertCamerasMenu() {
        return this.vertCamerasMenu;
    }

    public WebElement getVertCamerasCanon() {
        clickVertDesktops();
        return getVertCamerasMenu().vertCanon;
    }

    public int getVertcanonCount() {
        if (getVertCamerasMenu() == null) {
            clickVertCameras();
        }
        return getVertCamerasMenu().vertCanonCount;
    }

    public WebElement getVertCamerasNikon() {
        clickVertCameras();
        return getVertCamerasMenu().vertNikon;
    }

    public int getVertNikonCount() {
        if (getVertCamerasMenu() == null) {
            clickVertCameras();
        }
        return getVertCamerasMenu().vertCanonCount;
    }

    // - - - - - - - - -PLAYERS - - - - - - - - - -

    public WebElement getVertPlayers() {
        return this.vertPlayers;
    }
    //	+++++++++++++++++++++++++++++++
    */
    
    // Functional

	public String getVerticalMenuCategoryText(CategoryRepository category) {
		return getVerticalMenuCategory(category).getText();
	}

	public String getVerticalMenuSubCategoryText(CategoryRepository category, int index) {
		return getVerticalMenuSubCategory(category, index).getText();
	}

	public String getVerticalMenuSubCategoryText(CategoryRepository category, String subCategory) {
		return getVerticalMenuSubCategory(category, subCategory).getText();
	}

	/*
    // ++++++++DELETE++++++++++++++++++++++++
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

    // - - - - - - - - - TABLES - - - - - - - - - -

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

    //---------------CAMERAS---------------

    public String getVertCamerasText() {
        return getVertCameras().getText();
    }

    public String getVertCamerasCanonText() {
        return getVertCamerasCanon().getText();
    }

    public String getVertCamerasNikonText() {
        return getVertCamerasNikon().getText();
    }

    //--------Players-------------------------

    public String getVertPlayersText() {
        return getVertPlayers().getText();
    }

    ///+++++++++++++++++++++++++++++++
    */
	
    // set Data

    public void clickHome() {
        getHome().click();
    }

	public void clickVerticalMenuCategory(CategoryRepository category) {
		getVerticalMenuCategory(category).click();
	}

	public void clickVerticalMenuSubCategory(CategoryRepository category, int index) {
		getVertMenuPage(category).clickSubCategoryVert(index);
	}

	public void clickVerticalMenuSubCategory(CategoryRepository category, String subCategory) {
		getVertMenuPage(category).clickSubCategoryVert(subCategory);
	}

	/*
    // ++++++++DELETE+++++++++++++++++++++++++++
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

    //DELETE
    public void clickVertLaptops() {
        //getLaptops().click();
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

    //----------TABLES-----------------------------------------------

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

    // - - - - - - - - -PHONES - - - - - - - - - - -

    public void clickVertPhones() {
        getVertPhones().click();
    }

    public void clickVertPnonesApple() {
        getVertApplePhones().click();
    }

    public void clickVertPhonesHtc() {
        getVertHtcPhones().click();
    }

    public void clickVertPhonesOthers() {
        getVertOthersPhones().click();
    }

    public void clickVertPhonesSamsung() {
        getVertSamsungPhones().click();
    }

//----------------------CAMERAS------------------

    public void clickVertCameras() {
        getVertCameras().click();
    }

    public void clickVertCamerasCanon() {
        getVertCamerasCanon().click();
    }

    public void clickVertCamerasNikon() {
        getVertCamerasNikon().click();
    }

//---------------Players------------------

    public void clickVertPlayers() {
        getVertPlayers().click();
        // TODO
    }
    //	++++++++++++++++++++
    */
    
    // Business Logic

    public HomePage gotoHome() {
        clickHome();
        return new HomePage(driver, HomePage.HOME_PRODUCT_COLUMN);
    }

	public VerticalMenuPage gotoVertMenuSubCategory(CategoryRepository category, int index) {
		clickVerticalMenuSubCategory(category, index);
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

	public VerticalMenuPage gotoVertMenuSubCategory(CategoryRepository category, String subCategory) {
		clickVerticalMenuSubCategory(category, subCategory);
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

	/*
    // +++++++DELETE +++++++++++++++
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
    //+++++++++++++++++
      */
}
