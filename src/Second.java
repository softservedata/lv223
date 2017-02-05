/*
 * 331. a) Дано натуральное число n. Можно ли представить его в виде
 * суммы трех квадратов натуральных чисел? Если можно, то указать тройку
 * x,y,z таких натуральних чисел, что n = x^2 + y^2 + z^2.
 */

/**
 * Second.java
 * @version     1.0 29 January 2017
 * @author      Yulian Shutiak
 */
package com.softserve.edu;

import java.util.Scanner;

/**
 * Class description.
 */
public final class Second {
    /**
     * Scanner.
     */
    private static Scanner in;

    /**
     * Constructor Example documentation comment.
     */
    protected Second() {

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
        int sum = 0;
        boolean k = false;
        boolean once = true;

        // loop for 3 integers

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                for (int z = 0; z <= n; z++) {
                    sum = (x * x) + (y * y) + (z * z);

                    if (sum == n) {
                        // if a number is found
                        k = true;

                        if (once) {
                            print("x=" + x + ", y=" + y + ", z=" + z);
                            once = false;
                        }
                    }

                }
            }
        }

        if (!k) {
            print("The're is not such number.");
        }

    }

    /**
     * Method print.
     *
     * @param s
     *            <b>Parameter</b> s.
     */
    static void print(final String s) {
        System.out.println(s);
    }
}
