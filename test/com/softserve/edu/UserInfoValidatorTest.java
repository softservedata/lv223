package com.softserve.edu;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserInfoValidatorTest {
    
  UserInfoValidator validator;
  
  @BeforeTest
  public void init(){
      validator = new UserInfoValidator();
  }
   
  @Test
  public void validateDigitValueTest() {   
      validator.validateDigitValue(2);
      
  }
  
  @Test
  public void getUserValueTest(){
      validator.getUserValue();
  }
  
  @Test
  public void checkIsDigitTest(){
      validator.checkIsDigit("");
      
  }
  
}
