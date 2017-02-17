package com.softserve.edu;

import java.text.MessageFormat;

public class ConsoleOutput {
    
    public static String successAbilityMessage = "Input valule could be expressed as summ of squares.";
    public static String failAbilityMessage = "Input valule couldn't be expressed as summ of squares.";
    public static String allResultsHeaderMessage = "All results: ";

    /**
     * Prints formatted count or result groups of calculated parameters.
     * @param count of groups.
     */
    public void printCounOfResults(final int count) {
        String message = MessageFormat.format("Count of result pairs: {0}", 
                count);
        System.out.println(message);
    }
    
    /**
     * Prints to console calculated maximum degree.
     * @param value of maximum degree
     */
    public final void printResult(int value) {
        String message = MessageFormat.format("The max degree is: {0}", value);
        System.out.println(message);
    }
    
    /**
     * Prints formatted result of representing value.
     * @param x integer value to print as "x" to console
     * @param y integer value to print as "y" to console
     */
    public void printOneRepresentResult(final int x, final int y) {
        String message = MessageFormat.format("At least one result: x = {0}, "
                + "y = {1};", x, y);
        System.out.println(message);
    }
    
    /**
     * Prints formatted result of representing value.
     * @param x integer value to print as "x" to console
     * @param y integer value to print as "y" to console
     * @param z integer value to print as "z" to console
     */
    public void printOneRepresentResult(final int x, final int y, final int z) {
        String message = MessageFormat.format("At least one result: x = {0}, " 
    + "y = {1}, z = {2};", x, y, z);
        System.out.println(message);
    }
    
    /**
     * Prints formatted results of representing value.
     * @param x integer value to print as "x" to console
     * @param y integer value to print as "y" to console
     */
    public void printRepresentResults(final int x, final int y) {
        String message = MessageFormat.format("x = {0}, y = {1};", x, y);
        System.out.println(message);
    }
    
    /**
     * Prints formatted results of representing value.
     * @param x integer value to print as "x" to console
     * @param y integer value to print as "y" to console
     * @param z integer value to print as "z" to console
     */
    public void printRepresentResults(final int x, final int y, final int z) {
        String message = MessageFormat.format("x = {0}, y = {1}, z = {2};", 
                x, y, z);
        System.out.println(message);
    }
}
