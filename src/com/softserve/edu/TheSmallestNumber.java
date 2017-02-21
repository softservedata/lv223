/*
 * com.softserve.edu
 */
package com.softserve.edu;

/**
 * TheSmallestNumber.java.
 * @version     1.0 29 January 2017
 * @author      Yulian Shutiak
 */
public class TheSmallestNumber {

    /**
    * Natural number that user enters.
    */
    private int initialNumber = 1;

    /**
    * Counter.
    */
    private int counter = 1;

    /**
     * TODO Auto-generated constructor stub.
     */
    public TheSmallestNumber() {
        System.out.println("Enter a natural number: ");
    }

    /**
     * @param userNumber
     *            <b>Parameter</b> from Command Line.
     */
    final void initialNumber(final int userNumber) {
        initialNumber = userNumber;
    }

    /**
     * @return counter
     * @param userNumber
     *            <b>Parameters</b> from Command Line.
     */
    public int count(final int userNumber) {
        int n = userNumber;
        while (n > 1) {
            n /= 2;
            counter++;
        }
        return counter;
    }

    /**
    * A print method.
    */
    final void print() {
        System.out.println("The nearest 2 ^ n, that is greater than "
    + initialNumber + " is: " + counter);
        System.out.println("The nearest number is 2^" + counter + ", i.e. "
    + Math.pow(2, counter));
    }
}
