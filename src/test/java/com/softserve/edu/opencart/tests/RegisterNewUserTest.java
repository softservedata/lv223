package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.AccountCreatedPage;
import com.softserve.edu.opencart.pages.MyAccountPage;
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
		Assert.assertEquals(accountCreatedPage.getCongratulationsLabelText(),
				AccountCreatedPage.EXPECTED_MESSAGE);
		Thread.sleep(1000);
		//
		// Steps
		MyAccountPage myAccountPage = accountCreatedPage.gotoMyAccountPage();
		Thread.sleep(1000);
		//
		// Return to previous state
		myAccountPage.gotoSubLogoutPage();
		//
		//ReporterWrapper.get().takeScreenShot();
		ReporterWrapper.get().info("Done");
		logger.info("Done");
	}

}
