/*
 * @(#)Tasks.java
 *
 * Copyright (c) No copyright.
 *
 * This program is used to find all natural numbers, which are less then
 * and are mutually simple with the provided number; all natural numbers,
 * which are less then  * and are mutually amicable with the provided number;
 * provide solution for uncommon situation, when You need to find all
 * numbers from array, divided  * by 5 and not divided by 7.
 *
 */

package com.softserve.edu;

/**
 * Class used to provide solution.
 *
 * @version 1.1
 * @author Andrii Mishchuk
 * @since 02.2017
 */

public final class Tasks {

    /**
     * Simple constructor.
     */
    private Tasks() {
    }

    /**
     * Method main used for providing the solution, according to the input.
     *
     * @param args Unused.
     *
     */

    public static void main(final String[] args) {
        Input input = new Input();
        input.scanInput();
    }

}
