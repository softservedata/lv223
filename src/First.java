/*
 * 108.Дано натуральне число n. Получить наименьшее число вида 2^r,
 *     превосходящее n.
 */

/**
 * First.java
 * @version     1.0 29 January 2017
 * @author      Yulian Shutiak
 */
package com.softserve.edu;

import java.util.Scanner;

/**
 * Class description.
 */
public final class First {
    /**
     * Scanner.
     */
    private static Scanner in;

    /**
     * Constructor Example documentation comment.
     */
    protected First() {

    }

    /**
     * Method main documentation comment.
     *
     * @param args
     *            <b>Parameters</b> from Command Line.
     */
    public static void main(final String[] args) {
        print("Enter an integer number: ");

        in = new Scanner(System.in);
        int n = in.nextInt();
        int m = n;
        int counter = 1;

        // counts the number to power

        while (n > 1) {
            n /= 2;
            counter++;
        }

        print("The nearest 2 ^ n, that is greater than " + m
                + " is: " + counter);
        print("The nearest number is 2^" + counter + ", i.e. "
                + Math.pow(2, counter));
    }

    /**
     * Method print.
     * @param s
     *            <b>Parameter</b> s.
     */
    static void print(final String s) {
        System.out.println(s);
    }
}
