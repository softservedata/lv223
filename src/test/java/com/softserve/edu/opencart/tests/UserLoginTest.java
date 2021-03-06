package com.softserve.edu.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.LoginPage;
import com.softserve.edu.opencart.tools.ProviderUtils;

public class UserLoginTest extends TestRunner {

	@DataProvider
    public Object[][] validUsers() {
        return new Object[][] {
            {  UserRepository.get().getJohnDoeUser() },
        };
    }

	@DataProvider
    public Object[][] csvUsers() {
        return ProviderUtils.toMultiArray(UserRepository.getUsersFromCsvFile());
    }


	@Test(dataProvider = "csvUsers")
	public void checkLogin(IUser user) throws InterruptedException {
		// Precondition
		System.out.println("\t+++login = " + user.getEmail()
			+ "\t+++password = " + user.getPassword());
		//
		// Steps
		HomePage homePage = Application.get().load();
		Thread.sleep(1000);
		//
		// Check
		LoginPage loginPage = homePage.gotoLoginPage();
		Thread.sleep(1000);
		//
		//loginPage.successUserLogin(user);
		//loginPage.unsuccessfulLogin(invalidUser);
		//
		// Return to previous state
		//Application.remove();
	}

}
