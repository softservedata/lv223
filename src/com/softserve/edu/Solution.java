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
    /** List, used to provide with method results. Type Integer. */
    ArrayList<Integer> resultList;
    /** List, used to provide with method results. Type String.*/
    ArrayList<String> resuList;


    /**
     * Method is used to find all mutually simple
     * numbers to the provided number.
     *
     *@param k
     * Provided number, which should be analyzed.
     *
     *@return resultList
     *List, which contains data after analysis.
     *
     */

    public ArrayList<Integer> findLessAndSimple(final int k) {
       resultList = new ArrayList<Integer>();
       if (k <= 0) {
           System.out.println("Please provide with valid input. Press N");
       } else {
           for (int i = l; i < k;) {
               for (int j = l; j <= i && i < k;) {
                   if (i % j == 0 && i >= j && k % j == 0) {
                           i++;
                           j = l;
                       } else {
                           if (j == i) {
                               /** Adds numbers, which met the condition
                                *  to list.*/
                               resultList.add(i);
                                   i++;
                               j = (l - 1);
                           }
                           j++;
                   }
               }
                       }
           }
         return resultList;
    }

    /**
     * Method is used to find all mutually amicable
     * numbers to the provided number.
     *
     *@param list
     *Provides amount of numbers for analysis.
     *
     *@return resultList
     * List, which contains data after analysis.
     */


    public ArrayList<String> findMutuallyAmicable(
            final ArrayList<Integer> list) {
        resuList = new ArrayList<String>();
        for (int i = list.get(0); i <= list.get(1); i++) {
            for (int n = 1; n < i; n++) {
                        if (i % n == 0) {
                    sum += n;
                }
            }
            if (sum > list.get(0) && sum <= list.get(1)) {
                for (int j = list.get(0); j <= list.get(1); j++) {
                    if (sum == j) {
                        for (int n = 1; n < j; n++) {
                            if (j % n == 0) {
                        sum1 += n;
                    }
                }
                        if (sum1 == i) {
                            /** Adds to list numbers, which met the condition.*/
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
    * @param list
    * Array list is used to provide us with numbers, that should be
    * analyzed for meeting the condition : be divided by 5 and not be
    * divided by 7.

    * @return resultList
    * List, which contains data after analysis.
    */

    public ArrayList<Integer> findNumbersConditionMet(
            final ArrayList<Integer> list) {
    resultList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (((list.get(i) % firstNumber) == 0)
               && ((list.get(i) % secondNumber) != 0)) {
                   count++;
                   sum += list.get(i);
            }
        }

        /** Prints out the amount of numbers, which met the condition and
         * the summ of such numbers. */
        resultList.add(count);
        resultList.add(sum);
        return resultList;
    }

}
