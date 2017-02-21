/*
 * com.softserve.edu
 */
package com.softserve.edu;

import java.util.ArrayList;

/**
 * PythagoreanTriples.java.
 *
 * @version 1.0 29 January 2017
 * @author Yulian Shutiak
 */
public class PythagoreanTriples {

    /**
     * TODO Auto-generated constructor stub.
     */
    public PythagoreanTriples() {
        System.out.println("Enter a natural number: ");
    }

    /**
     * Total sum.
     */
    private int sum = 1;
    /**
     * Check if the numbers is found.
     */
    private boolean theNumberIsFound = false;

    /**
     * @return list
     * @param userNumber
     *            <b>Parameters</b> from Command Line.
     */
    public final ArrayList<Integer> count(final int userNumber) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int a = 1; a <= userNumber; a++) {
            for (int b = a; b <= userNumber; b++) {
                for (int c = b; c <= userNumber; c++) {
                    sum = (a * a) + (b * b);

                    if ((sum == (c * c)) && (sum <= userNumber)) {
                        // if a number is found
                        theNumberIsFound = true;

                        System.out.println((a * a) + " + "
                        + (b * b) + " = " + (c * c));
                        list.add(a * a);
                        list.add(b * b);
                        list.add(c * c);
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
