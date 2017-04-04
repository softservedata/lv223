package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 03.04.2017.
 */
public class ASortingPage  extends AMenuPage{
    private static final String SORTING_TYPE_LIST_SELECTOR = "//button[contains(@id, 'list-view')]";
    private static final String SORTING_TYPE_GRID_SELECTOR = "//button[contains(@id, 'grid-view')]";
    private static final String PRODUCT_COMPARE_SELECTOR = "//a[contains(@id, 'compare-total')]";
    private static final String SORT_OPTIONS_DROP_MENU_SELECTOR = "//select[contains(@id, 'input-sort')]";
    private static final String SHOW_OPTIONS_DROP_MENU_SELECTOR = "//select[contains(@id, 'input-limit')]";
    private static final String SHOW_OPTION_15_SELECTOR = "//option[contains(text(), '15')]";
    private static final String SHOW_OPTION_25_SELECTOR = "//option[contains(text(), '25')]";
    private static final String SHOW_OPTION_50_SELECTOR = "//option[contains(text(), '50')]";
    private static final String SHOW_OPTION_75_SELECTOR = "//option[contains(text(), '75')]";
    private static final String SHOW_OPTION_100_SELECTOR = "//option[contains(text(), '100')]";
    private static final String SORT_OPTION_DEFAULT_SELECTOR = "//option[contains(text(), 'Default')]";
    private static final String SORT_OPTION_NAMEAZ_SELECTOR = "//option[contains(text(), 'Name (A - Z)')]";
    private static final String SORT_OPTION_NAMEZA_SELECTOR = "//option[contains(text(), 'Name (Z - A)')]";
    private static final String SORT_OPTION_PRICE_LOW_HIGH_SELECTOR = "//option[contains(text(), 'Price (Low > High)')]";
    private static final String SORT_OPTION_PRICE_HIGH_LOW_SELECTOR = "//option[contains(text(), 'Price (High > Low)')]";
    private static final String SORT_OPTION_RATING_HIGHEST_SELECTOR = "//option[contains(text(), 'Rating (Highest)')]";
    private static final String SORT_OPTION_RATING_LOWEST_SELECTOR = "//option[contains(text(), 'Rating (Lowest)')]";
    private static final String SORT_OPTION_MODELAZ_SELECTOR = "//option[contains(text(), 'Model (A - Z)')]";
    private static final String SORT_OPTION_MODELZA_SELECTOR = "//option[contains(text(), 'Model (Z - A)')]";

    WebElement sortingTypeList;
    WebElement sortingTypeGrid;
    WebElement productCompare;
    WebElement sortOptionsDropMenu;
    WebElement showOptionsDropMenu;
    ShowOptionsMenu showOptionsMenu;
    SortOptionsMenu sortOptionsMenu;

    public ASortingPage(WebDriver driver) {
        super(driver);
        this.sortingTypeList = driver.findElement(By.xpath(SORTING_TYPE_LIST_SELECTOR));
        this.sortingTypeGrid = driver.findElement(By.xpath(SORTING_TYPE_GRID_SELECTOR));
        this.productCompare = driver.findElement(By.xpath(PRODUCT_COMPARE_SELECTOR));
        this.sortOptionsDropMenu = driver.findElement(By.xpath(SORT_OPTIONS_DROP_MENU_SELECTOR));
        this.showOptionsDropMenu = driver.findElement(By.xpath(SHOW_OPTIONS_DROP_MENU_SELECTOR));
        showOptionsMenu = new ShowOptionsMenu(driver);
        sortOptionsMenu = new SortOptionsMenu(driver);

    }


    private class ShowOptionsMenu {
        public final WebElement showOption15;
        public final WebElement showOption25;
        public final WebElement showOption50;
        public final WebElement showOption75;
        public final WebElement showOption100;

        public ShowOptionsMenu(WebDriver driver) {
            this.showOption15 = driver.findElement(By.xpath(SHOW_OPTION_15_SELECTOR));
            this.showOption25 = driver.findElement(By.xpath(SHOW_OPTION_25_SELECTOR));
            this.showOption50 = driver.findElement(By.xpath(SHOW_OPTION_50_SELECTOR));
            this.showOption75 = driver.findElement(By.xpath(SHOW_OPTION_75_SELECTOR));
            this.showOption100 = driver.findElement(By.xpath(SHOW_OPTION_100_SELECTOR));
        }
    }

    private class SortOptionsMenu {
        public final WebElement sortOptionDefault;
        public final WebElement sortOptionNameAZ;
        public final WebElement sortOptionNameZA;
        public final WebElement sortOptionPriceLowHigh;
        public final WebElement sortOptionPriceHighLow;
        public final WebElement sortOptionRatingHighest;
        public final WebElement sortOptionRatingLowest;
        public final WebElement sortOptionModelAZ;
        public final WebElement sortOptionModelZA;

        public SortOptionsMenu(WebDriver driver) {
            this.sortOptionDefault = driver.findElement(By.xpath(SORT_OPTION_DEFAULT_SELECTOR));
            this.sortOptionNameAZ = driver.findElement(By.xpath(SORT_OPTION_NAMEAZ_SELECTOR));
            this.sortOptionNameZA = driver.findElement(By.xpath(SORT_OPTION_NAMEZA_SELECTOR));
            this.sortOptionPriceLowHigh = driver.findElement(By.xpath(SORT_OPTION_PRICE_LOW_HIGH_SELECTOR));
            this.sortOptionPriceHighLow = driver.findElement(By.xpath(SORT_OPTION_PRICE_HIGH_LOW_SELECTOR));
            this.sortOptionRatingHighest = driver.findElement(By.xpath(SORT_OPTION_RATING_HIGHEST_SELECTOR));
            this.sortOptionRatingLowest = driver.findElement(By.xpath(SORT_OPTION_RATING_LOWEST_SELECTOR));
            this.sortOptionModelAZ = driver.findElement(By.xpath(SORT_OPTION_MODELAZ_SELECTOR));
            this.sortOptionModelZA = driver.findElement(By.xpath(SORT_OPTION_MODELZA_SELECTOR));
        }
    }

    //get
    public WebElement getSortingTypeList(){
        return this.sortingTypeList;
    }

    public WebElement getSortingTypeGrid(){
        return this.sortingTypeGrid;
    }

    public WebElement getProductCompare(){
        return this.productCompare;
    }

    public WebElement getSortOptionsDropMenu(){
        return this.sortOptionsDropMenu;
    }

    public WebElement getShowOptionsDropMenu(){
        return this.showOptionsDropMenu;
    }

    public WebElement getShowOptions15(){
        clickShowOptionsDropMenu();
        return this.showOptionsMenu.showOption15;
    }

    public WebElement getShowOptions25(){
        clickShowOptionsDropMenu();
        return this.showOptionsMenu.showOption25;
    }

    public WebElement getShowOptions50(){
        clickShowOptionsDropMenu();
        return this.showOptionsMenu.showOption50;
    }

    public WebElement getShowOptions75(){
        clickShowOptionsDropMenu();
        return this.showOptionsMenu.showOption75;
    }

    public WebElement getShowOptions100(){
        clickShowOptionsDropMenu();
        return this.showOptionsMenu.showOption100;
    }

    public WebElement getSortOptionDefault(){
        clickSortOptionsDropMenu();
        return this.sortOptionsMenu.sortOptionDefault;
    }

    public WebElement getSortOptionNameAZ(){
        clickSortOptionsDropMenu();
        return sortOptionsMenu.sortOptionNameAZ;
    }

    public WebElement getSortOptionNameZA(){
        clickSortOptionsDropMenu();
        return sortOptionsMenu.sortOptionNameZA;
    }

    public WebElement getSortOptionPriceLowHigh(){
        clickSortOptionsDropMenu();
        return this.sortOptionsMenu.sortOptionPriceLowHigh;
    }

    public WebElement getSortOptionPriceHighLow(){
        clickSortOptionsDropMenu();
        return this.sortOptionsMenu.sortOptionPriceHighLow;
    }

    public WebElement getSortOptionRatingHighest(){
        clickSortOptionsDropMenu();
        return this.sortOptionsMenu.sortOptionRatingHighest;
    }

    public WebElement getSortOptionRatingLowest(){
        clickSortOptionsDropMenu();
        return this.sortOptionsMenu.sortOptionRatingLowest;
    }

    public WebElement getSortOptionModelAZ(){
        clickSortOptionsDropMenu();
        return this.sortOptionsMenu.sortOptionModelAZ;
    }

    public WebElement getSortOptionModelZA(){
        clickSortOptionsDropMenu();
        return this.sortOptionsMenu.sortOptionModelZA;
    }

    //set
    public void clickSortingTypeList(){
        getSortingTypeList().click();
    }

    public void clickSortingTypeGrid(){
        getSortingTypeGrid().click();
    }

    public void clickProductCompare(){
        getProductCompare().click();
    }

    public void clickSortOptionsDropMenu(){
        getSortOptionsDropMenu().click();
        sortOptionsMenu = new SortOptionsMenu(driver);
    }

    public void clickShowOptionsDropMenu(){
        getShowOptionsDropMenu().click();
        showOptionsMenu = new ShowOptionsMenu(driver);
    }

    public void clickShowOption15(){
        getShowOptions15().click();
    }

    public void clickShowOption25(){
        getShowOptions25().click();
    }

    public void clickShowOption50(){
        getShowOptions50().click();
    }

    public void clickShowOption75(){
        getShowOptions75().click();
    }

    public void clickShowOption100(){
        getShowOptions100().click();
    }

    public void clickSortOptionDefault(){
        getSortOptionDefault().click();
    }

    public void clickSortOptionNameAZ(){
        getSortOptionNameAZ().click();
    }

    public void clickSortOptionNameZA(){
        getSortOptionNameZA().click();
    }

    public void clickSortOptionPriceLowHigh(){
        getSortOptionPriceLowHigh().click();
    }

    public void clickSortOptionPriceHighLow(){
        getSortOptionPriceHighLow().click();
    }

    public void clickSortOptionRatingHighest(){
        getSortOptionRatingHighest().click();
    }

    public void clickSortOptionRatingLowest(){
        getSortOptionRatingLowest().click();
    }

    public void clickSortOptionModelAZ(){
        getSortOptionModelAZ().click();
    }

    public void clickSortOptionModelZA(){
        getSortOptionModelZA().click();
    }

    //functional
    public ASortingPage gotoShowOption15() {
        clickShowOption15();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoShowOption25() {
        clickShowOption25();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoShowOption50() {
        clickShowOption50();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoShowOption75() {
        clickShowOption75();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoShowOption100() {
        clickShowOption100();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoSortOptionDefault() {
        clickSortOptionDefault();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoSortOptionNameAZ() {
        clickSortOptionNameAZ();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoSortOptionNameZA() {
        clickSortOptionNameZA();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoOptionPriceLowHigh() {
        clickSortOptionPriceLowHigh();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoOptionPriceHighLow() {
        clickSortOptionPriceHighLow();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoSortOptionRatingHighest() {
        clickSortOptionRatingHighest();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoSortOptionRatingLowest() {
        clickSortOptionRatingLowest();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoSortOptionModelAZ() {
        clickSortOptionModelAZ();
        return new ASortingPage(driver);
    }

    public ASortingPage gotoSortOptionModelZA() {
        clickSortOptionModelZA();
        return new ASortingPage(driver);
    }
}
