package com.softserve.edu.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.AccountCreatedPage;
import com.softserve.edu.opencart.pages.RegisterPage;
import com.softserve.edu.opencart.tools.ReporterWrapper;

public class RegisterNewUserTest extends TestRunner {

	@DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] newUsers() {
        return new Object[][] {
            { UserRepository.get().getNewUser() },
        };
    }
	
	@Test(dataProvider = "newUsers")
	public void checkRegisterUser(IUser newUser) throws InterruptedException {
		logger.info("Start");
		ReporterWrapper.get().info("Start");
		// Precondition
		// Steps
		RegisterPage registerPage = Application.get()
				.load().gotoRegisterPage();
		Thread.sleep(1000);
		//
		AccountCreatedPage accountCreatedPage = registerPage.gotoAccountCreated(newUser);
		//
		// Check
//		Assert.assertTrue(verticalMenuPage.getProductByDetailsLink(product.getDetails())
//				.getDescriptionText().trim().toLowerCase()
//				.contains(product.getDescription().toLowerCase()));
		Thread.sleep(2000);
		//
		// Return to previous state
		//Application.remove();
		//ReporterWrapper.get().takeScreenShot();
		ReporterWrapper.get().info("Done");
		logger.info("Done");
	}

}
