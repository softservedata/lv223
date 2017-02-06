package com.softserve.atqc;
/**
 * Class provides functionality to calculate maximum degree that number 4
 * can be raised to and the result is less than input value.
 * @version 02.02.2017
 */

public class CalculateResult {

    /**
     * Related to the task value to be raised to degree.
     */
    private final int numberToRaise = 4;

    /**
     * Method calculates maximum degree that 4 can be
     * raised to and  less than input value.
     * @param value parsed parameter from command line as the number.
     * @return maximum degree, integer value.
     */
    public final int getMaxDegree(final int value) {
        int result = 1;
        int maxDegree = 0;
        while (result < value) {
            result = numberToRaise * result;
            if (result < value) {
                maxDegree++;
            }
        }
        return maxDegree;
    }
}
