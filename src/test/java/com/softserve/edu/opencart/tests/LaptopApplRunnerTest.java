package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.tools.ProviderUtils;

public class LaptopApplRunnerTest extends TestRunner {

	@DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] desctopProducts() {
        //return new Object[][] {
        //    //{  ProductRepository.getPhonesAndPDAs() },
        //    {  ProductRepository.getPhonesAndPDAs().get(1) },
        //};
        return ProviderUtils.toMultiArray(ProductRepository.getPhonesAndPDAs());
    }
	
	@Test(dataProvider = "desctopProducts")
	public void checkComponentAppl(Product product) throws InterruptedException {
		// Precondition
		// Steps
		VerticalMenuPage verticalMenuPage = Application.get()
				.load().gotoPhonesAll();
		Thread.sleep(2000);
		//
		//System.out.println("*****Actual: "+verticalMenuPage.getProductByDetailsLink(product.getDetails())
		//		.getDescriptionText().trim().toLowerCase());
		//System.out.println("*****Expected: "+product.getDescription().toLowerCase());
		// Check
		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink(product.getDetails())
				.getDescriptionText().trim().toLowerCase()
				.contains(product.getDescription().toLowerCase()));
		Thread.sleep(2000);
		//
		// Return to previous state
		//Application.remove();
	}

}
