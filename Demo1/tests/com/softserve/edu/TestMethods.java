package com.softserve.edu;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMethods {
    NaturalDivisors natdiv = new NaturalDivisors();
    PrimeDivisors primdiv = new PrimeDivisors();
    SameLastDigits sld = new SameLastDigits();
    
  @Test
 // @Parameters(value = "n")
  public void checkNaturalDivisors() {
      
      ArrayList<Integer> actual;
      actual = natdiv.func(79);
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 79));
      
      Assert.assertEquals(actual, expected);
  }
  
  @Test
   public void checkPrimeDivisors() {
       
       ArrayList<Integer> actual;
       actual = primdiv.func(100);
       ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 5));
       
       Assert.assertEquals(actual, expected);
   }
  
  @Test
  public void checkSameLastDigits() {
      
      ArrayList<Integer> actual;
      actual = sld.func(99);
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 5, 6, 25, 76));
      
      Assert.assertEquals(actual, expected);
  }
}
