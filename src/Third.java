/*
 *  554. Дано натуральное число n. Получить все пифагоровы тройки
 *  натуральных чисел, каждое из которых не превосходит n, т.е. все такие
 *  тройки натуральных чисел a, b, c,
 *  что a^2 + b^2 = c^2 (a <= b <= c <= n).
 */

/**
 * Third.java
 * @version     1.0 29 January 2017
 * @author      Yulian Shutiak
 */
package com.softserve.edu;

import java.util.Scanner;

/**
 * Class description.
 */
public final class Third {
    /**
     * Scanner.
     */
    private static Scanner in;

    /**
     * Constructor Example documentation comment.
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
        print("Enter an integer number: ");

        in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        boolean k = false;

        // loop for 3 integers

        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                for (int c = b; c <= n; c++) {
                    sum = (a * a) + (b * b);

                    if ((sum == (c * c)) && (sum <= n)) {
                        // if a number is found
                        k = true;
                        print((a * a) + " + " + (b * b) + " = " + (c * c));

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
