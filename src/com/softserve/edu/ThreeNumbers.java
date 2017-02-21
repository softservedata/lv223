/*
 * com.softserve.edu
 */
package com.softserve.edu;

import java.util.ArrayList;

/**
 * TheSmallestNumber.java.
 * @version     1.0 29 January 2017
 * @author      Yulian Shutiak
 */
public class ThreeNumbers {

    /**
     * Total sum.
     */
    private int sum = 1;
    /**
     * Check if the numbers is found.
     */
    private boolean theNumberIsFound = false;
    /**
     * Show this three numbers once.
     */
    private boolean once = true;

    /**
     * TODO Auto-generated constructor stub.
     */
    public ThreeNumbers() {
        System.out.println("Enter a natural number: ");
    }

    /**
     * @return list
     * @param userNumber
     *            <b>Parameters</b> from Command Line.
     */
    public final ArrayList<Integer> count(final int userNumber) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x = 1; x <= userNumber; x++) {
            for (int y = 1; y <= userNumber; y++) {
                for (int z = 1; z <= userNumber; z++) {
                    sum = (x * x) + (y * y) + (z * z);

                    if (sum == userNumber) {
                        // if a number is found
                        theNumberIsFound = true;

                        if (once) {
                            System.out.println("x=" + x
                                    + ", y=" + y + ", z=" + z);
                            once = false;
                            list.add(x);
                            list.add(y);
                            list.add(z);
                        }
                    }

                }
            }
        }

        if (!theNumberIsFound) {
            System.out.println("The're is not such number.");
        }
        return list;

    }

}
