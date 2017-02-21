/*
 * 331 a) Given a natural number n. Can you represent it as a sum of three
 * squares of natural numbers? If possible, specify
 * the three x, y, z (once) such that n = x ^ 2 + y ^ 2 + z ^ 2.
 */
package com.softserve.edu;

import java.util.Scanner;

/**
 * Second.java.
 * @version     1.0 29 January 2017
 * @author      Yulian Shutiak
 */
public final class Second {

    /**
     * Empty constructor.
     */
    protected Second() {

    }

    /**
     * Method main documentation comment.
     *
     * @param args
     *            <b>Parameter</b> from Command Line.
     */
    public static void main(final String[] args) {

        ThreeNumbers tn = new ThreeNumbers();
        int n;
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        do {
             n = in.nextInt();
        } while (n < 1);
        tn.count(n);
    }
}
