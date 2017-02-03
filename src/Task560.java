/*
 * @(#)Task323.java
 *
 * Copyright (c) No copyright.
 *
 * This program is used to find all natural numbers, which are less then
 * and are mutually amicable with the provided number.
 *
 */

package com.tasks.adc;

/**
 * Class used to provide solution.
 *
 * @version 1.1
 * @author Andrii Mishchuk
 * @since 02.2017
 */

public final class Task560 {

    /**
     * Simple constructor.
     */

    private Task560() {
    }

    /** Used to summarize all dividers of numbers in first loop.*/
    private int sum1 = 0;
    /** Used to summarize all dividers of numbers in second loop.*/
    private int sum = 0;
    /** Used to provide start position for loop.*/
    private final int startNumber = 200;
    /** Used to provide start position for loop.*/
    private final int endNumber = 300;

    /**
     * Method is used to find all mutually amicable
     * numbers to the provided number.
     *
     */

    public void findMutuallyAmicable() {
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
                            System.out.println(i + " is mutually amicable to "
                                     + j);
                        }
                    }
                    sum1 = 0;
                }
            }
            sum = 0;
            }
    }

    /**
     * Method main used for providing the solution, according to the input.
     *
     * @param args Unused.
     *
     */

    public static void main(final String[] args) {
        Task560 solutTask = new Task560();
        solutTask.findMutuallyAmicable();
        }
    }
