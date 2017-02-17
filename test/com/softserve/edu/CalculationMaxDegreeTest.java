package com.softserve.edu;

import org.testng.annotations.Test;

import com.softserve.edu.find_max_degree.CalculationMaxDegree;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class CalculationMaxDegreeTest{
    
  private CalculationMaxDegree calc;
    
  @BeforeTest
  public void initialiseClass(){
      calc = new CalculationMaxDegree();
  }
  
  @Test
  public void getMaxDegreeTest(){   
      int result = calc.getMaxDegree(16);
      Assert.assertEquals(result, 1);
  }
  
}
