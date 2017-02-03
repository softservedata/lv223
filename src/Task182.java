/*
 * @(#)Task182.java
 *
 * Copyright (c) No copyright.
 *
 * This program is used to provide solution
 * for uncommon situation, when You need to
 * find all numbers from array, divided
 * by 5 and not divided by 7.
 *
 */

package com.tasks.adv;

/**
 * Class used to provide solution.
 *
 * @version 1.1
 * @author Andrii Mishchuk
 * @since 02.2017
 */

public final class Task182 {
    /**
     * Simple constructor.
     */
    private Task182() {
    }

    /** Used to count numbers, that match the condition.*/
    private int count = 0;
    /** Used to summarize numbers, that match the condition.*/
    private int sum = 0;
    /** First number in codition, that should be mathed.*/
    private final int firstNumber = 5;
    /** Second number in condition, that should be matched. */
    private final int secondNumber = 7;

    /**
    *Method is used to analyze provided numbers for meeting the condition.
    *
    *@param j
    * Input number, which specifies the size of array for numbers,
    * which should be ananalyzed for condition.
    *
    * @param list
    * Array list is used to provide us with numbers, that should be
    * analyzed for meeting the condition : be divided by 5 and not be
    * divided by 7.
    */

    public void findNumbersConditionMet(final int j, final int[] list) {
        for (int i = 0; i < j; i++) {
            if (((list[i] % firstNumber) == 0)
               && ((list[i] % secondNumber) != 0)) {
                   count++;
                   sum += list[i];
            }
        }
        /** Prints out the amount of numbers, which met the condition and
         * the summ of such numbers. */
        System.out.println("Count: " + count + ". Sum: " + sum + ".");
    }

/**
 * Method main used for providing the solution, according to input.
 *
 * @param args Unused.
 *
 */
    public static void main(final String[] args) {
        /** Provides the size of array.*/
        int j;
        //int j = 7;

        /** Array, which provides all numbers, to be analyzed.*/
        int[] list = new int[j];
        //int[] inputNumbers = new int[]{15, 20, 24, 12, 7, 4, 25};

        Task182 solutTask = new Task182();
        solutTask.findNumbersConditionMet(j, inputNumbers);
    }

}
