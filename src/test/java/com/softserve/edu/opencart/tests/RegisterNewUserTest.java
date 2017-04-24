package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.AccountCreatedPage;
import com.softserve.edu.opencart.pages.EditAccountPage;
import com.softserve.edu.opencart.pages.LogoutPage;
import com.softserve.edu.opencart.pages.MyAccountPage;
import com.softserve.edu.opencart.pages.RegisterPage;
import com.softserve.edu.opencart.pages.RegisterValidatorPage;
import com.softserve.edu.opencart.tools.ReporterWrapper;

public class RegisterNewUserTest extends TestRunner {

	@DataProvider // (parallel = true) // Do not use parallel attribute
	public Object[][] newUsers() {
		return new Object[][] { { UserRepository.get().getNewUser() }, };
	}

	@Test(dataProvider = "newUsers")
	public void checkRegisterUser(IUser newUser) throws InterruptedException {
		logger.info("Start");
		ReporterWrapper.get().info("Start");
		// Precondition
		//
		// Steps
		RegisterPage registerPage = Application.get().load().gotoRegisterPage();
		Thread.sleep(1000);
		//
		AccountCreatedPage accountCreatedPage = registerPage.gotoAccountCreated(newUser);
		//
		// Check
		Assert.assertEquals(accountCreatedPage.getCongratulationsLabelText(),
				AccountCreatedPage.ACCOUNT_CREATED_PAGE_EXPECTED_MESSAGE);
		Thread.sleep(1000);
		//
		// Steps
		MyAccountPage myAccountPage = accountCreatedPage.gotoMyAccountPage();
		Thread.sleep(1000);
		//
		// Return to previous state
		LogoutPage logoutPage = myAccountPage.gotoSubLogoutPage();
		//
		// Check
		Assert.assertEquals(logoutPage.getAccountLogoutLabelText(), LogoutPage.LOGOUT_PAGE_EXPECTED_MESSAGE);
		Thread.sleep(1000);
		//
		// Return to Previous State
		logoutPage.gotoContinueHomePage();
		Thread.sleep(1000);
		//
		// ReporterWrapper.get().takeScreenShot();
		ReporterWrapper.get().info("Done");
		logger.info("Done");
	}

	@Test(dataProvider = "newUsers", dependsOnMethods = { "checkRegisterUser" })
	public void checkRegisterExistUser(IUser existUser) throws InterruptedException {
		logger.info("Start");
		ReporterWrapper.get().info("Start");
		// Precondition
		//
		// Steps
		RegisterPage registerPage = Application.get().load().gotoRegisterPage();
		Thread.sleep(1000);
		//
		RegisterValidatorPage registerValidatorPage = registerPage.gotoAccountDenied(existUser);
		//
		// Check
		Assert.assertEquals(registerValidatorPage.getAlertDangerLabelText(),
				RegisterValidatorPage.REGISTER_VALIDATOR_PAGE_EXPECTED_MESSAGE);
		Thread.sleep(1000);
		//
		// Return to Previous State
		registerValidatorPage.gotoLogoHomePage();
		Thread.sleep(1000);
		//
		// ReporterWrapper.get().takeScreenShot();
		ReporterWrapper.get().info("Done");
		logger.info("Done");
	}

	@Test(dataProvider = "newUsers", dependsOnMethods = { "checkRegisterUser" })
	public void checkLoginExistUser(IUser existUser) throws InterruptedException {
		logger.info("Start");
		ReporterWrapper.get().info("Start");
		// Precondition
		//
		// Steps
		MyAccountPage myAccountPage = Application.get().load()
				.gotoLoginPage().successUserLogin(existUser);
		Thread.sleep(1000);
		//
		// Check
		Assert.assertEquals(myAccountPage.getMyAccountLabelText(),
				MyAccountPage.MY_ACCOUNT_PAGE_EXPECTED_MESSAGE);
		Thread.sleep(1000);
		//
		// Steps
		EditAccountPage editAccountPage = myAccountPage.gotoEditAccountPage();
		Thread.sleep(1000);
		//
		// Check
		Assert.assertEquals(editAccountPage.getEmailInputValue(),
				existUser.getEmail());
		Thread.sleep(1000);
		//
		// Return to previous state
		LogoutPage logoutPage = editAccountPage.gotoSubLogoutPage();
		//
		// Check
		Assert.assertEquals(logoutPage.getAccountLogoutLabelText(), LogoutPage.LOGOUT_PAGE_EXPECTED_MESSAGE);
		Thread.sleep(1000);
		//
		// Return to Previous State
		logoutPage.gotoContinueHomePage();
		Thread.sleep(1000);
		//
		// ReporterWrapper.get().takeScreenShot();
		ReporterWrapper.get().info("Done");
		logger.info("Done");
	}

}
