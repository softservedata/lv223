package com.softserve.edu;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class TestMethods {
    NaturalDivisors natdiv = new NaturalDivisors();
    PrimeDivisors primdiv = new PrimeDivisors();
    SameLastDigits sld = new SameLastDigits();
    
  @Test
 // @Parameters(value = "n")
  public void checkNaturalDivisors() {
      
      ArrayList<Integer> actual;
      actual = natdiv.func(79);
      ArrayList<Integer> expected = new ArrayList<Integer>();
      expected.add(1);
      expected.add(79);
      
      Assert.assertEquals(actual, expected);
  }
  
  @Test
   public void checkPrimeDivisors() {
       
       ArrayList<Integer> actual;
       actual = primdiv.func(100);
       ArrayList<Integer> expected = new ArrayList<Integer>();
       expected.add(1);
       expected.add(2);
       expected.add(5);
       
       Assert.assertEquals(actual, expected);
   }
  
  @Test
  public void checkSameLastDigits() {
      
      ArrayList<Integer> actual;
      actual = sld.func(99);
      ArrayList<Integer> expected = new ArrayList<Integer>();
      expected.add(1);
      expected.add(5);
      expected.add(6);
      expected.add(25);
      expected.add(76);
      
      Assert.assertEquals(actual, expected);
  }
}
