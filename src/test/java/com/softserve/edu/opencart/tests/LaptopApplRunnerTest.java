package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.tools.ProviderUtils;
import com.softserve.edu.opencart.tools.ReporterWrapper;

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
	public void checkComponentAppl(IProduct product) throws InterruptedException {
		logger.info("Start");
		ReporterWrapper.get().info("Start");
		System.out.println("***@Test MAVEN" + System.getProperty("surefire.reports.directory"));
		// Precondition
		// Steps
//		VerticalMenuPage verticalMenuPage = Application.get()
//				.load().gotoPhonesAll();
		VerticalMenuPage verticalMenuPage = Application.get()
				.load().gotoShowAll(CategoryRepository.PHONES);
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
		ReporterWrapper.get().takeScreenShot();
		ReporterWrapper.get().info("Done");
		logger.info("Done");
	}

}
