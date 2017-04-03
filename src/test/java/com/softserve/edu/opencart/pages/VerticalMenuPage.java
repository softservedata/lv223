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
				//System.out.println("+++currentWebElement.getText() = "+currentWebElement.getText());
				//System.out.println("+++subCategory = "+subCategory);
				if (currentWebElement.getText().trim().toLowerCase()
						.contains(subCategory.trim().toLowerCase())) {
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

	// Fields

	private WebElement home;
	// Vertical Menu
	private List<VertMenuPage> verticalMenu;

	protected VerticalMenuPage(WebDriver driver, int column) {
		super(driver, column);
		initVerticalMenu();

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

	public VerticalMenuPage gotoCurrencyUSDollar() {
		clickDollar();
		return new VerticalMenuPage(driver, MENU_PRODUCT_COLUMN);
	}

}
