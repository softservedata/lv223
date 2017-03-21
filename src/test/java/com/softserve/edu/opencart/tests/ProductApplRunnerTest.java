package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;

public class ProductApplRunnerTest extends TestRunner {

	@DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] desctopProducts() {
        return new Object[][] {
            //{  ProductRepository.getDesktopIMac() },
            {  ProductRepository.getDesktopIMac() },
        };
    }
	
	@Test(dataProvider = "desctopProducts")
	public void checkComponentAppl(Product product) throws InterruptedException {
		// Precondition
		// Steps
//		VerticalMenuPage verticalMenuPage = Application.get()
//				.load().gotoDesktopsAll();
		VerticalMenuPage verticalMenuPage = Application.get()
				.load().gotoShowAll(CategoryRepository.DESKTOPS);
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink(product.getDetails())
				.getDescriptionText().trim().toLowerCase()
				.contains(product.getDescription().toLowerCase()));
		Thread.sleep(1000);
		//
		// Return to previous state
		//Application.remove();
	}

}
