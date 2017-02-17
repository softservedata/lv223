package com.softserve.edu;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMethodsXML {
    
    NaturalDivisors natdiv = new NaturalDivisors();
    PrimeDivisors primdiv = new PrimeDivisors();
    SameLastDigits sld = new SameLastDigits();
    
    
  @Test
  @Parameters({"n", "expected"})
  public void checkNaturalDivisorsXML(int n, String expected) {
      ArrayList<Integer> actual;
      actual = natdiv.func(n);
      String[] data = expected.split(",");
      ArrayList<Integer> expectedInt = new ArrayList<Integer>();
      for(int i = 0;i < data.length;i++)
      {
          expectedInt.add(Integer.parseInt(data[i]));
      }
      

      Assert.assertEquals(actual, expectedInt);
  }
  
  @Test
  @Parameters({"nForPrimeDivisors", "expectedPrimeDivisors"})
  public void checkPrimeDivisorsXML(int n, String expectedPrimeDivisors) {
      ArrayList<Integer> actual;
      actual = primdiv.func(n);
      String[] data = expectedPrimeDivisors.split(",");
      ArrayList<Integer> expectedInt = new ArrayList<Integer>();
      for(int i = 0;i < data.length;i++)
      {
          expectedInt.add(Integer.parseInt(data[i]));
      }
      

      Assert.assertEquals(actual, expectedInt);
  }
  
  @Test
  @Parameters({"nForSameLastDigits", "expectedSameLastDigits"})
  public void checkSameLastDigitsXML(int n, String expectedPrimeDivisors) {
      ArrayList<Integer> actual;
      actual = sld.func(n);
      String[] data = expectedPrimeDivisors.split(",");
      ArrayList<Integer> expectedInt = new ArrayList<Integer>();
      for(int i = 0;i < data.length;i++)
      {
          expectedInt.add(Integer.parseInt(data[i]));
      }
      

      Assert.assertEquals(actual, expectedInt);
  }
}
