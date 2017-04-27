package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.ShoppingCartPage;
import com.softserve.edu.opencart.pages.VerticalMenuPageModified;

public class ShoppingCartTest extends TestRunner {

	@DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] cartProducts() {
        return new Object[][] {
            {  ProductRepository.getSamsungSyncMaster941BW(),
            	UserRepository.get().getOrlAnn() },
        };
    }

	//@Test(dataProvider = "cartProducts")
	public void checkAddProduct(IProduct product, IUser user) throws InterruptedException {
		// Precondition
		// Steps
		//System.out.println(product.getCategory().toString());
		//Thread.sleep(10000);
		VerticalMenuPageModified verticalMenuPageModified = Application.get().load()
				.gotoLoginPage()
				.successUserLogin(user)
				.gotoMenuSubCategory(product.getCategory(), product.getSubCategory())
				.addToCartProductByDetailsLink(product.getDetails());
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(verticalMenuPageModified.getAddCartMessageText().contains(
				String.format(VerticalMenuPageModified.SUCCESS_ADD_SHOPPING_CART_MESSAGE,
						product.getDetails())));
		Thread.sleep(1000);
		//
		// Steps
		ShoppingCartPage shoppingCartPage = verticalMenuPageModified.gotoShoppingCart();
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(shoppingCartPage.isProductPresentInCartList(product.getDetails()));
		Thread.sleep(2000);
		//
		// Return to previous state
		//shoppingCartPage.gotoLogout();
		// TODO
		Application.get().getWebDriver().get("http://atqc-shop.epizy.com/index.php?route=account/logout");
		//Application.remove();
	}

	
	//@Test(dataProvider = "cartProducts", dependsOnMethods = { "checkAddProduct" })
	public void checkUpdateProduct(IProduct product, IUser user) throws InterruptedException {
		// Precondition
		// Steps
		//System.out.println(product.getCategory().toString());
		//Thread.sleep(10000);
		ShoppingCartPage shoppingCartPage = Application.get().load()
				.gotoLoginPage()
				.successUserLogin(user)
				.gotoShoppingCart();
		Thread.sleep(1000);
		//
		int previousQuantity = Integer.valueOf(shoppingCartPage
				.getCartComponentByName(product.getDetails())
				.getProductQuantityText());
		System.out.println("previousQuantity = " + previousQuantity);
		//
		shoppingCartPage = shoppingCartPage.updateProductQuantityByName(product.getDetails(), previousQuantity + 1);
		Thread.sleep(1000);
		//
		int newQuantity = Integer.valueOf(shoppingCartPage
				.getCartComponentByName(product.getDetails())
				.getProductQuantityText());
		//
		// Check
		Assert.assertEquals(newQuantity, previousQuantity + 1);
		Thread.sleep(1000);
		//
		// Return to previous state
		//shoppingCartPage.gotoLogout();
		// TODO
		Application.get().getWebDriver().get("http://atqc-shop.epizy.com/index.php?route=account/logout");
		//Application.remove();
	}
	
	//@Test(dataProvider = "cartProducts", dependsOnMethods = { "checkAddProduct", "checkUpdateProduct" })
	//@Test(dataProvider = "cartProducts")
	public void checkDeleteProduct(IProduct product, IUser user) throws InterruptedException {
		// Precondition
		// Steps
		//System.out.println(product.getCategory().toString());
		//Thread.sleep(10000);
		ShoppingCartPage shoppingCartPage = Application.get().load()
				.gotoLoginPage()
				.successUserLogin(user)
				.gotoShoppingCart()
				.deleteProductByName(product.getDetails());
		Thread.sleep(1000);
		//
		// Check
		Assert.assertFalse(shoppingCartPage.isProductPresentInCartList(product.getDetails()));
		Thread.sleep(1000);
		//
		// Return to previous state
		//shoppingCartPage.gotoLogout();
		// TODO
		Application.get().getWebDriver().get("http://atqc-shop.epizy.com/index.php?route=account/logout");
		//Application.remove();
	}
	
	@Test(dataProvider = "cartProducts")
	public void checkAddProductToCompactPage(IProduct product, IUser user) throws InterruptedException {
		// Precondition
		// Steps
		//System.out.println(product.getCategory().toString());
		//Thread.sleep(10000);
		VerticalMenuPageModified verticalMenuPageModified = Application.get().load()
				.gotoLoginPage()
				.successUserLogin(user)
				.gotoMenuSubCategory(product.getCategory(), product.getSubCategory())
				.addToCartProductByDetailsLink(product.getDetails());
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(verticalMenuPageModified.getAddCartMessageText().contains(
				String.format(VerticalMenuPageModified.SUCCESS_ADD_SHOPPING_CART_MESSAGE,
						product.getDetails())));
		Thread.sleep(1000);
		//
		// Steps
		ShoppingCartPage shoppingCartPage = verticalMenuPageModified.gotoShoppingCart();
		Thread.sleep(1000);
		//
		// Check
		Assert.assertTrue(shoppingCartPage.openShoppingCartButton()
				.isProductPresentInCartList(product.getDetails()));
		Thread.sleep(1000);
		//
		// Return to previous state
		//Application.get().setFullScreen();
		//Thread.sleep(1000);
		//shoppingCartPage.gotoWishList().gotoSubLogoutPage().gotoContinueHomePage();
		//shoppingCartPage.gotoLogout();
		// TODO
		//Application.get().getWebDriver().get("http://atqc-shop.epizy.com/index.php?route=account/logout");
		//Application.remove();
	}

}
