package com.softserve.edu.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.GeneralException;

public abstract class AMenuPage extends ATopPage {
	
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public static enum CategoryRepository {
		DESKTOPS("Desktops", "20", "PC", "Mac"),
		LAPTOPS("Laptops & Notebooks", "18", "Acer", "Apple", "HP", "Others"),
		COMPONENTS("Components", "25", "Mice and Trackballs", "Monitors", "Printers", "Scanners", "Web Cameras"),
		TABLETS("Tablets", "57", "Apple", "Other", "Samsung"),
		SOFTWARE("Software", "17", "Apple", "Microsoft", "Other"),
		PHONES("Phones & PDAs", "24", "Apple", "HTC", "Others", "Samsung"),
		CAMERAS("Cameras", "33", "Canon", "Nikon"),
		PLAYERS("MP3 Players", "34", "Apple", "Others");
		//
		private String category;
		private String idPath;
		private List<String> subCategories;

		private CategoryRepository(String category, String idPath, String... subCategories) {
			this.category = category;
			this.idPath = idPath;
			this.subCategories = new ArrayList<String>();
			init(subCategories);
		}

		private void init(String... subCategories){
			if (subCategories != null) {
				for (String currentSubCategories : subCategories) {
					this.subCategories.add(currentSubCategories);
				}
			}
		}
		
		public String getCategory() {
			return category;
		}

		public String getIdPath() {
			return idPath;
		}

		public List<String> getSubCategories() {
			return subCategories;
		}

		public String getSubCategoriesByPartialName(String name) {
			String subCategory = null;
			for (String currentSubCategory : getSubCategories()) {
				if (currentSubCategory.trim().toLowerCase()
						.contains(name.trim().toLowerCase())) {
					subCategory = currentSubCategory;
					break;
				}
			}
			if (subCategory == null) {
				throw new GeneralException(SUBCATEGORY_NOT_FOUND_ERROR_MESSAGE);
			}
			return subCategory;
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class ItemMenuPage {
		private static final String SUBCATEGORY_LIST_XPATH = "//div[@class='dropdown-inner']//li/a[contains(@href,'&path=%s_')]";
		private static final String SHOW_ALL_PARTIALLINKTEXT = "Show All %s";
		//
		// Fields
		private final CategoryRepository category;
		private WebElement categoryItem;
		private List<WebElement> subCategoryItems;
		private WebElement showAll;

		public ItemMenuPage(CategoryRepository category) {
			this.category = category;
			this.categoryItem = driver.findElement(By.linkText(category.getCategory()));
		}

		// PageObject

		private void initSubCategories() {
			getCategoryItem().click();
			this.subCategoryItems = driver
					.findElements(By.xpath(String.format(SUBCATEGORY_LIST_XPATH, category.getIdPath())));
			this.showAll = driver
					.findElement(By.partialLinkText(String.format(SHOW_ALL_PARTIALLINKTEXT, category.getCategory())));
		}

		// get Data

		public CategoryRepository getCategory() {
			return this.category;
		}

		public WebElement getCategoryItem() {
			return this.categoryItem;
		}

		public List<WebElement> getSubCategoryItems() {
			initSubCategories();
			return this.subCategoryItems;
		}

		public WebElement getSubCategoryItems(String subCategory) {
			WebElement resultWebElement = null;
			for (WebElement currentWebElement : getSubCategoryItems()) {
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

		public WebElement getShowAll() {
			initSubCategories();
			return this.showAll;
		}

		// Functional

		public String getCategoryItemText() {
			return getCategoryItem().getText();
		}

		public List<String> getSubCategoryItemsTexts() {
			List<String> subCategories = new ArrayList<String>();
			for (WebElement currentWebElement : getSubCategoryItems()) {
				subCategories.add(currentWebElement.getText());
			}
			return subCategories;
		}

		public String getShowAllText() {
			return getShowAll().getText();
		}

		// set Data

		public void clickCategoryItem() {
			getCategoryItem().click();
		}

		public void clickSubCategoryItems(int index) {
			getSubCategoryItems().get(index).click();
		}

		public void clickSubCategoryItems(String subCategory) {
			getSubCategoryItems(subCategory).click();
		}

		public void clickShowAll() {
			getShowAll().click();
		}

	}

	// Fields

	private static final String SUBCATEGORY_NOT_FOUND_ERROR_MESSAGE = "Subcategory not found";
	public static final int MENU_PRODUCT_COLUMN = 4;
	//
	// Horizontal Menu
	private List<ItemMenuPage> horizontalMenu;

	protected AMenuPage(WebDriver driver) {
		super(driver);
		initHorizontalMenu();
		// if l10n exist
	}

	// PageObject

	private void initHorizontalMenu() {
		horizontalMenu = new ArrayList<ItemMenuPage>();
		for (CategoryRepository currentCategory : CategoryRepository.values()) {
			horizontalMenu.add(new ItemMenuPage(currentCategory));
		}
	}

	private ItemMenuPage getItemMenuPage(CategoryRepository category) {
		ItemMenuPage itemMenuPage = null;
		for (ItemMenuPage currentItemMenu : horizontalMenu) {
			if (currentItemMenu.getCategory() == category) {
				itemMenuPage = currentItemMenu;
				break;
			}
		}
		if (itemMenuPage == null) {
			throw new GeneralException(SUBCATEGORY_NOT_FOUND_ERROR_MESSAGE);
		}
		return itemMenuPage;
	}

	// get Data

	public WebElement getHorizontalMenuCategory(CategoryRepository category) {
		return getItemMenuPage(category).getCategoryItem();
	}

	public WebElement getHorizontalMenuSubCategory(CategoryRepository category, int index) {
		return getItemMenuPage(category).getSubCategoryItems().get(index);
	}

	public WebElement getHorizontalMenuSubCategory(CategoryRepository category, String subCategory) {
		return getItemMenuPage(category).getSubCategoryItems(subCategory);
	}

	public WebElement getShowAllMenuSubCategory(CategoryRepository category) {
		return getItemMenuPage(category).getShowAll();
	}

	// Functional

	public String getHorizontalMenuCategoryText(CategoryRepository category) {
		return getHorizontalMenuCategory(category).getText();
	}

	public String getHorizontalMenuSubCategoryText(CategoryRepository category, int index) {
		return getHorizontalMenuSubCategory(category, index).getText();
	}

	public String getHorizontalMenuSubCategoryText(CategoryRepository category, String subCategory) {
		return getHorizontalMenuSubCategory(category, subCategory).getText();
	}

	public String getShowAllMenuSubCategoryText(CategoryRepository category) {
		return getShowAllMenuSubCategory(category).getText();
	}

	// set Data

	public void clickHorizontalMenuCategory(CategoryRepository category) {
		getHorizontalMenuCategory(category).click();
	}

	public void clickHorizontalMenuSubCategory(CategoryRepository category, int index) {
		getItemMenuPage(category).clickSubCategoryItems(index);
	}

	public void clickHorizontalMenuSubCategory(CategoryRepository category, String subCategory) {
		getItemMenuPage(category).clickSubCategoryItems(subCategory);
	}

	public void clickShowAllMenuSubCategory(CategoryRepository category) {
		getItemMenuPage(category).clickShowAll();
	}

	// Business Logic

	public VerticalMenuPage gotoMenuSubCategory(CategoryRepository category, int index) {
		clickHorizontalMenuSubCategory(category, index);
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

	public VerticalMenuPage gotoMenuSubCategory(CategoryRepository category, String subCategory) {
		clickHorizontalMenuSubCategory(category, subCategory);
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

	public VerticalMenuPage gotoShowAll(CategoryRepository category) {
		clickShowAllMenuSubCategory(category);
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

}
