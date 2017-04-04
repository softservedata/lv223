package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FPF on 30.03.2017.
 */
public class WishListPage extends ARightMenuRegistered {

    protected List<WishListComponent> wishListComponents;

    private static final String BASE_WISH_LIST_COMPONENT_SELECTOR = "";

    protected WishListPage(WebDriver driver) {
        super(driver);
        wishListComponents = getComponents();
    }

    private List<WebElement> getItems(){
        List<WebElement>list = driver.findElements(By.xpath(BASE_WISH_LIST_COMPONENT_SELECTOR));
        return list;
    }

    private List<WishListComponent> getComponents(){
        List<WishListComponent> wishListComponents = new ArrayList<>();
        for (WebElement currentElement : getItems()) {
            WishListComponent product = new WishListComponent(driver, currentElement);
            wishListComponents.add(product);
        }
        return wishListComponents;
    }

    //TODO   getByIndex, getByName, getCount,

    //-----------------------------------------------------------------------

    private class WishListComponent{

        private static final String COMPONENT_IMAGE_XPATH_SELECTOR = "";
        private static final String COMPONENT_PRODUCT_NAME_XPATH_SELECTOR = "";
        private static final String COMPONENT_MODEL_XPATH_SELECTOR = "";
        private static final String COMPONENT_STOCK_XPATH_SELECTOR = "";
        private static final String COMPONENT_UNIT_PRICE_XPATH_SELECTOR = "";
        private static final String COMPONENT_ADD_TO_CART_XPATH_SELECTOR = "";
        private static final String COMPONENT_REMOVE_XPATH_SELECTOR = "";
        private static final String COMPONENT_DRIVER_XPATH_SELECTOR = "";

        private WebElement image;
        private WebElement productName;
        private WebElement model;
        private WebElement stock;
        private WebElement unitPrice;
        private WebElement addToCart;
        private WebElement remove;
        private WebDriver driver;

        public WishListComponent(WebDriver driver, WebElement baseElemnt){
            this.driver = driver;
            this.image = driver.findElement(By.xpath(COMPONENT_IMAGE_XPATH_SELECTOR));
            this.productName = driver.findElement(By.xpath(COMPONENT_PRODUCT_NAME_XPATH_SELECTOR));
            this.model = driver.findElement(By.xpath(COMPONENT_MODEL_XPATH_SELECTOR));
            this.stock = driver.findElement(By.xpath(COMPONENT_IMAGE_XPATH_SELECTOR));
            this.unitPrice = driver.findElement(By.xpath(COMPONENT_IMAGE_XPATH_SELECTOR));
            this.addToCart = driver.findElement(By.xpath(COMPONENT_IMAGE_XPATH_SELECTOR));
            this.remove = driver.findElement(By.xpath(COMPONENT_IMAGE_XPATH_SELECTOR));
        }

        public WebElement getImage() {
            return image;
        }

        public WebElement getProductName() {
            return productName;
        }

        public WebElement getModel() {
            return model;
        }

        public WebElement getStock() {
            return stock;
        }

        public WebElement getUnitPrice() {
            return unitPrice;
        }

        public WebElement getAddToCart() {
            return addToCart;
        }

        public WebElement getRemove() {
            return remove;
        }


        //TODO getText, click, goto
    }
}
