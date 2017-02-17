package com.softserve.edu.two_squares;

import com.softserve.edu.ConsoleOutput;

/**
 * Class provides functionality to express value into sum of two squares.
 * 
 * @version 02.02.2017
 */
public class CalculationTwoSquares {

    ConsoleOutput toConsole = new ConsoleOutput();

    /**
     * Calculates and prints all groups of values that user value can be
     * represented.
     * 
     * @param value
     *            integer value read and parsed from console
     */
    public final boolean totalExpressValue(int value) {
        System.out.println(ConsoleOutput.allResultsHeaderMessage);
        int countOfResults = 0;
        for (int x = 1; x < value; x++) {
            for (int y = 1; y < value; y++) {
                if (x * x + y * y == value) {
                    countOfResults++;
                    toConsole.printRepresentResults(x, y);
                }
            }
        }
        if (countOfResults == 0) {
            return false;
        }
        toConsole.printCounOfResults(countOfResults);
        return true;
    }

    /**
     * Calculates and prints first group of values that user value can be
     * represented.
     * 
     * @param value
     *            integer value read and parsed from console
     * @return true if there is at least one result of calculations and false -
     *         if not.
     */
    public final boolean oneResultExpressValue(int value) {
        for (int x = 1; x < value; x++) {
            for (int y = 1; y < value; y++) {
                if (x * x + y * y == value) {
                    System.out.println(ConsoleOutput.successAbilityMessage);
                    toConsole.printOneRepresentResult(x, y);
                    return true;
                }

            }
        }
        System.out.println(ConsoleOutput.failAbilityMessage);
        return false;
    }
}
