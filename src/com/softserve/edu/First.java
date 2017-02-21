/*
 * 108. Given a natural number n. Get the smallest number
 * of the form 2 ^ r, exceeding n.
 */
package com.softserve.edu;

import java.util.Scanner;

/**
 * First.java.
 *
 * @version 1.0 29 January 2017
 * @author Yulian Shutiak
 */
public final class First {

    /**
     * Empty constructor.
     */
    private First() {

    }

    /**
     * @param args
     *            <b>Parameter</b> from Command Line.
     */
    public static void main(final String[] args) {

        TheSmallestNumber tsn = new TheSmallestNumber();
        int n;
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        do {
             n = in.nextInt();
        } while (n < 1);
        tsn.initialNumber(n);
        tsn.count(n);
        tsn.print();
    }
}
