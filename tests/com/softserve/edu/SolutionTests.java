
 /*
 * @(#)SolutionTests.java
 *
 * Copyright (c) No copyright.
 *
 * This class is used to provide us all the needed tests
 * for class Solution methods.
 *
 */

package com.softserve.edu;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

/**
 * Class used to provide tests.
 *
 * @version 1.0
 * @author Andrii Mishchuk
 * @since 02.2017
 */

public class SolutionTests {

/** Object used to test methods.*/
private Solution solution = new Solution();
/** Object used by DataProvider.*/
Object[][] data;
/** List of expected result, used for DataProvider. Integer.*/
ArrayList<Integer> expected;
/** List of expected result, used for DataProvider. String.*/
ArrayList<String> expectedResult;
/** List of actual result, used for DataProvider. Integer. */
ArrayList<Integer> actual;
/** List of actual result, used for DataProvider. String.*/
ArrayList<String> actualResult;

   /**

    * Simple constructor.

    */
   public SolutionTests() {
   }

/**Provides findLessAndSimple test with data.
 *
 * @return data
 * Object, which provides expected results.
 */

   @DataProvider
   public Object[][] findLessAndSimp() {
     data = new Object[3][2];
     data[0][0] = 50;
     data[0][1] = new ArrayList<Integer>(Arrays.asList(
             3, 7, 9, 11, 13, 17, 19, 21, 23, 27, 29, 31,
             33, 37, 39, 41, 43, 47, 49));
     data[1][0] = 25;
     data[1][1] = new ArrayList<Integer>(Arrays.asList(
             2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14, 16,
             17, 18, 19, 21, 22, 23, 24));
     data[2][0] = -3;
     data[2][1] = new ArrayList<Integer>();
     return data;
     }

    /**Provides findMutuallyAmicable test with data.
    *
    *
    * @return data
    * Object, which provides expected results.
    *
    */
   @DataProvider
   public Object[][] findMutuAmic() {
       data = new Object[4][2];
       data[0][0] = new ArrayList<Integer>(Arrays.asList(200, 300));
       data[0][1] = new ArrayList<String>(Arrays.asList(
               "220 is mutually amicable to 284",
               "284 is mutually amicable to 220"));
       data[1][0] = new ArrayList<Integer>(Arrays.asList(0, 300));
       data[1][1] = new ArrayList<String>(Arrays.asList(
               "6 is mutually amicable to 6", "28 is mutually amicable"
       + " to 28", "220 is mutually amicable to 284",
       "284 is mutually amicable to 220"));
       data[2][0] = new ArrayList<Integer>(Arrays.asList(300, 800));
       data[2][1] = new ArrayList<String>(Arrays.asList(
               "496 is mutually amicable to 496"));
       data[3][0] = new ArrayList<Integer>(Arrays.asList(0, 0));
       data[3][1] = new ArrayList<String>(Arrays.asList());
       return data;
   }

   /**Provides findNumbersConditionMet test with data.
    *
    *
    * @return data
    * Object, which provides expected results.
    *
    */
   @DataProvider
   public Object[][] findNumbCondMet() {
       data = new Object[3][2];
       data[0][0] = new ArrayList<Integer>(Arrays.asList(
               2, 5, 7, 15, 34, 64, 1, 8, 76, 87));
       data[0][1] = new ArrayList<Integer>(Arrays.asList(2, 20));
       data[1][0] = new ArrayList<Integer>(Arrays.asList(
               4, 9, 6, 13, 53, 54, 76, 8, 88, 64, 43,
               44, 55, 57, 65, 87, 51, 31));
       data[1][1] = new ArrayList<Integer>(Arrays.asList(4, 140));
       data[2][0] = new ArrayList<Integer>(Arrays.asList(
               9, 76, 76, 7, 8, 25, 55, 13, 25, 57, 70));
       data[2][1] = new ArrayList<Integer>(Arrays.asList(7, 245));
       return data;
   }

  /** Used to type test name before it's execution.
   *
   * @param method
   * Currently running method.
   */
  @BeforeMethod
    public void beforeMethod(final Method method) {
      System.out.println("Starting method : " + method.getName() + ".");
  }

  /** Used to type test name after it's execution.
   *
   * @param method
   * Currently running method.
   */
  @AfterMethod
    public void afterMethod(final Method method) {
      System.out.println(method.getName() + " finished execution.");
  }

  /** Test for findLessAndSimple method of class Solution.
   *
   * @param number
   * Number, which should be analyzed.
   *
   * @param list
   * Expected result.
   *
   */
  @Test(dataProvider = "findLessAndSimp", groups = "method1")
  public void findLessAndSimple(final int number,
          final ArrayList<Integer> list) {
      expected = list;
      actual = solution.findLessAndSimple(number);
      Assert.assertEquals(actual, expected);
  }

  /** Test for findMutuallyAmicable method of class Solution.
   *
   * @param list
   * Contains list of numbers for analysis.
   *
   * @param list1
   * Contains expected result.
   *
   *
   */
  @Test(dataProvider = "findMutuAmic", groups = "method2")
    public void findMutuallyAmicable(final ArrayList<Integer> list,
            final ArrayList<String> list1) {
      expectedResult = list1;
      actualResult = solution.findMutuallyAmicable(list);
      Assert.assertEquals(actualResult, expectedResult);
  }

  /** Test for findNumbersConditionMet method of class Solution.
   *
   * @param list
   * Contains data for analysis
   *
   * @param list1
   * Contains expected result of test
   *
   */
  @Test(dataProvider = "findNumbCondMet", groups = "method3")
    public void findNumbersConditionMet(final ArrayList<Integer> list,
            final ArrayList<Integer> list1) {
      expected = list1;
      actual = solution.findNumbersConditionMet(list);
      Assert.assertEquals(actual, expected);
  }
}
