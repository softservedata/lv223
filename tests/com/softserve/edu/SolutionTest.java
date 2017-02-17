package com.softserve.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SolutionTest {
   
    
  @BeforeTest
  public void beforeTest() {
     private Solution solut = new Solution();
      System.out.println("Starting test");
  }

  @AfterTest
  public void afterTest() {
      System.out.println("Test ended.");
  }


  @Test  
  public void findLessAndSimple() {      
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 7, 9, 11, 13, 17, 19, 21, 23, 27, 29, 31, 33, 37, 39, 41, 43, 47, 49));
      ArrayList<Integer> actual = solut.findLessAndSimple(50);
      Assert.assertEquals(actual, expected);
  }

  @Test
  public void findMutuallyAmicable() { 
      ArrayList<String> expected = new ArrayList<String>(Arrays.asList("220 is mutually amicable to 284", "284 is mutually amicable to 220"));
      ArrayList<String> actual = solut.findMutuallyAmicable();
      Assert.assertEquals(actual, expected);
  }

  @Test
  public void findNumbersConditionMet() {      
      int[] inputNumbers = new int[] {15, 20, 24, 12, 7, 4, 25};
      int[] expected = new int[]{3, 60}; 
      int arraySize = 7;
      int[] actual = solut.findNumbersConditionMet(arraySize, inputNumbers);
      Assert.assertEquals(actual, expected);
  } 
}
