package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.tools.ProviderUtils;

public class ComponentsTest extends TestRunner{
   
    @DataProvider
    public Object[][] dp() {
        return ProviderUtils.toMultiArray(ProductRepository.getComponentsMonitors());
    }

    @Test(dataProvider = "dp")
    public void f(Product product) throws InterruptedException {
        
        VerticalMenuPage verticalMenuPage = Application.get()
                .load().gotoComponentsMonitors();   
        
        System.out.println("Actual: " + verticalMenuPage.getProductByDetailsLink(product.getDetails())
                .getDescriptionText().trim().toLowerCase());
        System.out.println("Expected: " + product.getDescription().toLowerCase());
        
        Assert.assertTrue(verticalMenuPage.getProductByDetailsLink(product.getDetails())
                .getDescriptionText().trim().toLowerCase()
                .contains(product.getDescription().toLowerCase()));
        
        
      //  Assert.assertEquals(verticalMenuPage.getProductByDetailsLink(product.getDetails()).getPriceText(), expected);
//        verticalMenuPage.clickComponentsMice();
//        CountUtils.getCountInBrackets(verticalMenuPage.getComponentsMiceText());
        
    }
}
