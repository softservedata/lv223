/*
 * @(#)Task323.java
 *
 * Copyright (c) No copyright.
 *
 * This program is used to find all natural numbers, which are less then
 * and are mutually simple with the provided number.
 *
 */

package com.tasks.adb;

/**
 * Class used to provide solution.
 *
 * @version 1.1
 * @author Andrii Mishchuk
 * @since 02.2017
 */

public final class Task323 {

    /**
     * Simple constructor.
     */
    private Task323() {
    }

    /** Used to provide start position for loop.*/
    private final int l = 2;

    /**
     * Method is used to find all mutually simple
     * numbers to the provided number.
     *
     *@param k
     * Provided number, which should be analyzed.
     *
     */

    public void findLessAndSimple(final int k) {
        for (int i = l; i < k;) {
            for (int j = l; j <= i && i < k;) {
                if (i % j == 0 && i >= j && k % j == 0) {
                        i++;
                        j = l;
                    } else {
                        if (j == i) {
                            /** Prints out numbers, which met the condition.*/
                            System.out.println(i);
                                i++;
                            j = (l - 1);
                        }
                        j++;
                }
            }
                    }
    }

    /**
     * Method main used for providing the solution, according to the input.
     *
     * @param args Unused.
     *
     */

    public static void main(final String[] args) {
        int k;
        //int k = 50;

        Task323 solutTask = new Task323();
        solutTask.findLessAndSimple(k);
    }

        }
