package com.softserve.edu.opencart.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.VerticalMenuPage;
import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.pages.CompareProductSpan;
import com.softserve.edu.opencart.pages.ProductCompare;
import com.softserve.edu.opencart.pages.ProductPage;
import com.softserve.edu.opencart.pages.TopPage;


public class CompareProducts {
	
	@DataProvider
	public Object [][] provider (){
		return new Object[][] {
            {  ProductRepository.getDesktopIMac() },
        };
	}
	
	@Test(dataProvider = "provider")
	public void productsCompareFromSingleProductTest(IProduct product) throws InterruptedException{
		VerticalMenuPage verticalMenuPage = Application.get()
				.load().gotoShowAll(CategoryRepository.DESKTOPS);
		ProductPage singleProduct = verticalMenuPage.getProductByDetailsLink(product.getDetails()).gotoProductDetails();
		CompareProductSpan compareSection = singleProduct.choiceProductForCompare();
		Assert.assertEquals(compareSection.getProductCompareDescriptionText(), product.getDetails());
		ProductCompare productCompare = compareSection.getComparePageLink();
		Assert.assertTrue(productCompare.isComparedProductExistInTheList(product.getDetails()));;
	}
	
	//@Test(dataProvider = "provider")
	public void productsCompareFromListOfProductsTest(IProduct product) throws InterruptedException{
		VerticalMenuPage verticalMenuPage = Application.get()
				.load().gotoShowAll(CategoryRepository.DESKTOPS);
		CompareProductSpan compareSection  = verticalMenuPage.getProductByDetailsLink(product.getDetails()).choiceProductForCompare();
		Assert.assertEquals(compareSection.getProductCompareDescriptionText(), product.getDetails());
		ProductCompare productCompare = compareSection.getComparePageLink();
		Assert.assertTrue(productCompare.isComparedProductExistInTheList(product.getDetails()));;
	}
	
	

}
