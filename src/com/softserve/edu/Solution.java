/*
 * @(#)Solution.java
 *
 * Copyright (c) No copyright.
 *
 * This class is used to find all natural numbers, which are less then
 * and are mutually simple with the provided number; all natural numbers, 
 * which are less then  * and are mutually amicable with the provided number;
 * provide solution  * for uncommon situation, when You need to  * find all 
 * numbers from array, divided  * by 5 and not divided by 7.
 *
 */

package com.softserve.edu;

import java.util.ArrayList;

/**
 * Class used to provide solution.
 *
 * @version 1.1
 * @author Andrii Mishchuk
 * @since 02.2017
 */

public class Solution {
    
    /**
     * Simple constructor.
     */
    public Solution() {
    }
    
    /** Used to provide start position for loop.*/
    private final int l = 2;
    /** Used to count numbers, that match the condition.*/
    private int count = 0;
    /** Used to summarize numbers, that match the condition.*/
    private int sum = 0;
    /** First number in codition, that should be mathed.*/
    private final int firstNumber = 5;
    /** Second number in condition, that should be matched. */
    private final int secondNumber = 7;
    /** Used to summarize all dividers of numbers in first loop.*/
    private int sum1 = 0;    
    /** Used to provide start position for loop.*/
    private final int startNumber = 200;
    /** Used to provide start position for loop.*/
    private final int endNumber = 300;
    
    /**
     * Method is used to find all mutually simple
     * numbers to the provided number.
     *
     *@param k
     * Provided number, which should be analyzed.
     *
     */

    public ArrayList<Integer> findLessAndSimple(final int k) {
       ArrayList<Integer> resultList = new ArrayList<Integer>();
       for (int i = l; i < k;) {
            for (int j = l; j <= i && i < k;) {
                if (i % j == 0 && i >= j && k % j == 0) {
                        i++;
                        j = l;
                    } else {
                        if (j == i) {
                            /** Prints out numbers, which met the condition.*/
                            resultList.add(i);
                                i++;
                            j = (l - 1);
                        }
                        j++;
                }
            }
                    }
        return resultList;
    }
    
    

    /**
     * Method is used to find all mutually amicable
     * numbers to the provided number.
     *
     */

    public ArrayList<String> findMutuallyAmicable() {
        ArrayList<String> resuList = new ArrayList<String>();
        for (int i = startNumber; i <= endNumber; i++) {
            for (int n = 1; n < i; n++) {
                        if (i % n == 0) {
                    sum += n;
                }
            }
            if (sum > startNumber && sum <= endNumber) {
                for (int j = startNumber; j <= endNumber; j++) {
                    if (sum == j) {
                        for (int n = 1; n < j; n++) {
                            if (j % n == 0) {
                        sum1 += n;
                    }
                }
                        if (sum1 == i) {
                            /** Prints out numbers, which met the condition.*/
                            resuList.add(i + " is mutually amicable to "
                                     + j);
                        }
                    }
                    sum1 = 0;
                }
            }
            sum = 0;
            }
        return resuList;
    }   
    

    /**
    * Method is used to analyze provided numbers for meeting the condition.
    *
    * @param j
    * Input number, which specifies the size of array for numbers,
    * which should be ananalyzed for condition.
    *
    * @param list
    * Array list is used to provide us with numbers, that should be
    * analyzed for meeting the condition : be divided by 5 and not be
    * divided by 7.
    */

    public int[] findNumbersConditionMet(final int j, final int[] list) {
        int[] resultList = new int[2];       
        for (int i = 0; i < j; i++) {
            if (((list[i] % firstNumber) == 0)
               && ((list[i] % secondNumber) != 0)) {
                   count++;
                   sum += list[i];
            }
        }
        /** Prints out the amount of numbers, which met the condition and
         * the summ of such numbers. */
        resultList[0] = count;
        resultList[1] = sum;
        return resultList;
    }
    
    
    
}
