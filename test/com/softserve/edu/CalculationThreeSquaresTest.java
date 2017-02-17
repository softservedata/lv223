package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.three_squares.CalculationThreeSquares;

public class CalculationThreeSquaresTest {
  
  private CalculationThreeSquares calc;  
    
  @DataProvider
  public Object[][] dataSource() {
        return new Object[][] { 
            new Object[] { 75, true }, 
            new Object[] { 2, false },
            new Object[] { 12, true },
            new Object[] { 48, true },
        };
    }
  
  @BeforeClass
  public void init(){
      calc = new CalculationThreeSquares();
  }
    
  @Test(dataProvider = "dataSource")
  public void totalExpressValueTest(int value, boolean expResult) {
      System.out.println("\nStarting totalExpressValueTest...");
      boolean result = calc.oneResultExpressValue(value);
      Assert.assertEquals(result, expResult);
  }
  
  @Test(dataProvider = "dataSource")
  public void oneResultExpressTest(int value, boolean expResult){
      System.out.println("\nStarting oneResultExpressTest with DataProvider...");
      boolean result = calc.oneResultExpressValue(value);
      Assert.assertEquals(result, expResult);
  }
}
