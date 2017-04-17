package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.pages.ARightMenuPage;
import com.softserve.edu.opencart.pages.ARightMenuRegistered;
import com.softserve.edu.opencart.pages.ARightMenuUnregister;
import com.softserve.edu.opencart.pages.ChangePasswordPage;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.LoginPage;
import com.softserve.edu.opencart.pages.MyAccountPage;
import com.softserve.edu.opencart.pages.ReturningCustomerPage;
import com.softserve.edu.opencart.pages.WishListPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestRunner {

	@Test
	 public void passwordChangeTest() throws InterruptedException {
        HomePage homepage = Application.get().load();
        LoginPage loginPage = homepage.gotoLoginPage();

        loginPage.setEmail("orlann@ukr.net");
        loginPage.setPassword("qwerty");
       //loginPage.clickLoginButton();
        
        MyAccountPage myAccountPage = loginPage.clickLoginButton();
        
        if (myAccountPage == null) {
			throw new InterruptedException(LoginPage.INCORRECT_LOGIN_MESSAGE);
		}

      //  Assert.assertTrue(!loginPage.clickLoginButton());
       
     
        ChangePasswordPage changePasswordPage =  myAccountPage.gotoChangePasswordPage();
        
        changePasswordPage.changePassword("11111");
        Application app = Application.get();
        WebDriver driver = app.getWebDriver();
        boolean result = changePasswordPage.isPageContainsMessage(driver, ChangePasswordPage.SUCCESSFUL_CHANGE_PASSWORD_MESSAGE);
        System.out.println("result is getting");
       Thread.sleep(2000);
       revertPasswordDirectly(driver);
        System.out.println("Password is reverted");
        
//        System.out.println("newPasword"+changePasswordPage.getNewPasswordText());
//        System.out.println(changePasswordPage.getConfirmPasswordText());
        //ChangePasswordPage changePasswordPage1111 =  myAccountPage.gotoChangePasswordPage(); 
        //changePasswordPage.changePassword("qwerty");
        Assert.assertTrue(result);

    }
	private void revertPasswordDirectly(WebDriver driver){
		WebElement passwordButton = driver.findElement(By.xpath("//div[@class = 'list-group']/a[contains(@href, 'password')]"));
		passwordButton.click();
		WebElement newPassword = driver.findElement(By.id("input-password"));
		newPassword.sendKeys("qwerty");
		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys("qwerty");
		WebElement continueButton = driver.findElement(By.cssSelector("div[class='buttons clearfix'] .btn.btn-primary"));
		continueButton.click();
	};
}
