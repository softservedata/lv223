/*
 *  554. Given a natural number n. Get all Pythagorean triples
 *  of natural numbers, each of which does not exceed n,
 *  that all such triples of positive natural a, b, c,
 *  that a ^ 2 + b ^ 2 = c ^ 2 (a <= b <= c <= n).
 */
package com.softserve.edu;

import java.util.Scanner;

/**
 * Third.java.
 *
 * @version 1.0 29 January 2017
 * @author Yulian Shutiak
 */
public final class Third {

    /**
     * Empty constructor.
     */
    protected Third() {

    }

    /**
     * Method main documentation comment.
     *
     * @param args
     *            <b>Parameters</b> from Command Line.
     */
    public static void main(final String[] args) {

        PythagoreanTriples pt = new PythagoreanTriples();
        int n;
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        do {
            n = in.nextInt();
        } while (n < 1);
        pt.count(n);
    }
}
