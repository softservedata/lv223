package com.softserve.edu.opencart.tests;

//import com.mysql.jdbc.MySQLConnection;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.LoginPage;
import com.softserve.edu.opencart.pages.MyAccountPage;
import com.softserve.edu.opencart.tools.ProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created on 24.03.2017.
 */
public class LoginTest extends TestRunner{

    @DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] csvUsers() {
        return ProviderUtils.toMultiArray(UserRepository.getUsersFromCsvFile());
    }


    @DataProvider//(parallel = true) // Do not use parallel attribute
    public Object[][] csvInvalidUsers() {
        return ProviderUtils.toMultiArray(UserRepository.getUsersFromCsvFile("/invalidUsers.csv"));
    }


    //@Test
    public void logiatingTest(IUser user){
        HomePage homepage = Application.get().load();
        homepage.clickLogin();

    }

    @Test(dataProvider = "csvInvalidUsers")
    public void justTryTest2(IUser user) throws InterruptedException {
        HomePage homepage = Application.get().load();
        LoginPage loginPage = homepage.gotoLoginPage();
        loginPage = loginPage.unsuccessLogin(user);

        System.out.println(loginPage.getForgottenPasswordText());
    }

    //@Test(dataProvider = "csvUsers")
    public void justTryTest(IUser user){
        HomePage homepage = Application.get().load();
        LoginPage loginPage = homepage.gotoLoginPage();
        MyAccountPage myAccount = loginPage.successUserLogin(user);
        myAccount.gotoLogoutPage();
    }
}
