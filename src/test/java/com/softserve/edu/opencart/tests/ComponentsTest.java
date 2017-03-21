package com.softserve.edu.opencart.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.ProductComponent;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.tools.PriceUtils;
import com.softserve.edu.opencart.tools.ProviderUtils;
/**
 *
 * @version 03.2017
 * Class provides functionality for testing Components menu items.
 * Extends class TestRunner for driver initialization.
 */
public class ComponentsTest extends TestRunner {

    public final Logger logger = Logger.getLogger(TestRunner.class);
    /**
     * Provides test class with Product test data
     * @return Product object parsed from <.csv> file
     */
    @DataProvider
    public Object[][] componentsMonitorsProvider() {
        return ProviderUtils.toMultiArray(ProductRepository.getComponentsMonitorsCsv());
    }

    /**
     * Method get all monitors products from vertical menu page and
     * compares all product fields with those of expected product.
     * @param expectedProduct product from data provider
     */

    @Test(dataProvider = "componentsMonitorsProvider")
    public void monitorsTest(Product expectedProduct)  {
        logger.info("Start running monitors Test...");
        //VerticalMenuPage verticalMenuPage = Application.get().load().gotoComponentsMonitors();
        VerticalMenuPage verticalMenuPage = Application.get().load().gotoMenuSubCategory(CategoryRepository.COMPONENTS,
        		CategoryRepository.COMPONENTS.getSubCategoriesByPartialName("Monitors"));
        ProductComponent actualProduct = verticalMenuPage.getProductByDetailsLink(expectedProduct.getDetails());

        logger.info("Actual product: " + actualProduct.getDetailsLinkText() + ", expectedProduct: " +
                expectedProduct.getDetails());
        Assert.assertFalse(actualProduct.equals(null),
                String.format("There's no %s product on the page.", expectedProduct.getDetails()));
        Assert.assertTrue(actualProduct.getDescriptionText().trim().toLowerCase()
                .contains(expectedProduct.getDescription().toLowerCase()));
        Assert.assertTrue(PriceUtils.getStringPrice(actualProduct.getPriceText()).equals(expectedProduct.getPrice()));
        Assert.assertEquals(PriceUtils.getStringPrice(actualProduct.getExTaxPriceText()),
                expectedProduct.getExTaxPrice());
        logger.info("Test passed successfully!\n");
    }

    /**
     * Method get current currency from home page and checks correctness of
     * price currency of monitors items.
     */
    @Test
    public void checkMonitorsCurrencyTest() {
        logger.info("Starting checkMonitorsCurrency Test.....");
        HomePage home = Application.get().load();
        String actCurrency = home.getCurrencyText();
        //VerticalMenuPage verticalMenuPage = home.gotoComponentsScanners();
        VerticalMenuPage verticalMenuPage = home.gotoMenuSubCategory(CategoryRepository.COMPONENTS,
        		CategoryRepository.COMPONENTS.getSubCategoriesByPartialName("Scanners"));
        List<ProductComponent> products = verticalMenuPage.getProductsList();

        Assert.assertFalse(products.equals(null), "Product list of Monitors is empty.");
        products.forEach(
                product -> Assert.assertEquals(PriceUtils.getCurrencySymbol(product.getPriceText()), actCurrency));
    }
}
