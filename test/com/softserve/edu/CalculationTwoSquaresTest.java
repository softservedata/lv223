package com.softserve.edu;

import org.testng.annotations.Test;
import com.softserve.edu.two_squares.CalculationTwoSquares;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class CalculationTwoSquaresTest {
 
  CalculationTwoSquares calc;  
    
  @DataProvider
  public Object[][] dataSource() {
    return new Object[][] {
      new Object[] { 2, true },
      new Object[] { 50, true },
      new Object[] { 0, false },
      new Object[] { 30, false },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
      calc = new CalculationTwoSquares();
  }

  @Test(dataProvider = "dataSource")
  public void oneResultExpressValueTest(int value, boolean actResult){
      System.out.println("\nStart running oneResultExpressValueTest...");
     boolean result = calc.oneResultExpressValue(value);
     Assert.assertEquals(result, actResult);
  }
  
  @Test(dataProvider = "dataSource")
  public void totalExpressValueTest(int value, boolean actResult){
      System.out.println("\nStart running totalExpressValueTest...");
      boolean result = calc.totalExpressValue(value);
      Assert.assertEquals(result, actResult);
  }
}
