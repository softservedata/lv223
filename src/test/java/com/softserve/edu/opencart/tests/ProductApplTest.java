package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.appl.ApplicationSources;
import com.softserve.edu.opencart.appl.ApplicationSourcesRepository;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.pages.VerticalMenuPage;

public class ProductApplTest {

	@DataProvider//(parallel = true)
    public Object[][] desctopProducts() {
        return new Object[][] {
            { ApplicationSourcesRepository.getChromeCloud(),
            	ProductRepository.getDesktopIMac() }
        };
    }
	

	@Test(dataProvider = "desctopProducts")
	public void checkComponentAppl(ApplicationSources applicationSources,
			Product product) throws InterruptedException {
		// Precondition
		// Steps
//		VerticalMenuPage verticalMenuPage = Application.get(applicationSources)
//				.load().gotoDesktopsAll();
		VerticalMenuPage verticalMenuPage = Application.get(applicationSources)
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
		Application.remove();
	}

}
