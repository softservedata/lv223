package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by FPF on 30.03.2017.
 */
public class ChangePasswordPage extends ARightMenuRegistered {

   public static final String DISMATCH_PASSWORD_ERROR_MESSAGE="Password confirmation does not match password!";
   public static final String TOO_SHORT_PASSWORD_MESSAGE="Password must be between 4 and 20 characters!";
   public static final String SUCCESSFUL_CHANGE_PASSWORD_MESSAGE="Success: Your password has been successfully updated.";
   
	private WebElement newPassword;
    private WebElement confirmPassword;
    private WebElement backButton;
    private WebElement continueButton;
    
    protected ChangePasswordPage(WebDriver driver) {
        super(driver);
        
        this.newPassword = driver.findElement(By.id("input-password"));
        this.confirmPassword = driver.findElement(By.id("input-confirm"));
        this.backButton = driver.findElement(By.cssSelector("div[class='buttons clearfix'] .btn.btn-default"));
        this.continueButton = driver.findElement(By.cssSelector("div[class='buttons clearfix'] .btn.btn-primary"));
    }
    
    public WebElement getNewPassword() {
    	return newPassword;
    }
    
    public WebElement getConfirmPassword() {
    	return confirmPassword;
    }
    
    public WebElement getBackButton() {
    	return backButton;
    }
    
    public WebElement getContinueButton() {
    	return continueButton;
    }
    
    public String getNewPasswordText() {
   	return getNewPassword().getText();
    }

    public String getConfirmPasswordText() {
   	return getConfirmPassword().getText();
    }
    
    public void setNewPassword(String newPassword) {
    	getNewPassword().sendKeys(newPassword);
	}
    
    public void setConfirmPassword(String confirmPassword) {
    	getConfirmPassword().sendKeys(confirmPassword);
	}
    
    public void clickNewPassword() {
    	newPassword.click();
    }
    
    public void clickConfirmPassword() {
    	confirmPassword.click();
    }
    
    public void clickBackButton() {
    	backButton.click();
    }
    
    public void clickContinueButton() {
    	continueButton.click();
    }
    				
	public void changePassword(String newPassword) {
		setNewPassword(newPassword);
		setConfirmPassword(newPassword);
		clickContinueButton();
	}
    
    public boolean isPageContainsMessage(WebDriver driver, String message) {
		if (driver.getPageSource().contains(message)) {
			return true;
		}
		return false;
	}
    
}
