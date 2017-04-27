package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.tools.ProviderUtils;

public class ProductApplRunnerTest extends TestRunner {

	@DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] desctopProducts() {
        return new Object[][] {
            //{  ProductRepository.getDesktopIMac() },
            {  ProductRepository.getDesktopIMac() },
        };
    }

	@DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] csvProducts() {
        return ProviderUtils.toMultiArray(ProductRepository.getProductsFromCsvFile());
    }

	@DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] excelProducts() {
        return ProviderUtils.toMultiArray(ProductRepository.getProductsFromExcelFile());
    }

	@Test(dataProvider = "desctopProducts")
	//@Test(dataProvider = "csvProducts")
	//@Test(dataProvider = "desctopProducts")
	public void checkComponentAppl(IProduct product) throws InterruptedException {
		// Precondition
		// Steps
//		VerticalMenuPage verticalMenuPage = Application.get()
//				.load().gotoDesktopsAll();
//		VerticalMenuPage verticalMenuPage = Application.get()
//				.load().gotoShowAll(CategoryRepository.DESKTOPS);
		VerticalMenuPage verticalMenuPage = Application.get().load()
				.gotoMenuSubCategory(product.getCategory(),
						product.getSubCategory());
		Thread.sleep(1000);
		//
		// Check
		//System.out.println("*** verticalMenuPage.getProductByDetailsLink(product.getDetails()).getDescriptionText().trim().toLowerCase() = \n\t"
		//		+verticalMenuPage.getProductByDetailsLink(product.getDetails()).getDescriptionText().trim().toLowerCase());
		//System.out.println("*** product.getDescription().toLowerCase()) = \n\t" + product.getDescription().toLowerCase());
		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink(product.getDetails())
				.getDescriptionText().trim().toLowerCase()
				.contains(product.getDescription().toLowerCase()));
		Thread.sleep(1000);
		//
		// Return to previous state
		//Application.remove();
	}

}
