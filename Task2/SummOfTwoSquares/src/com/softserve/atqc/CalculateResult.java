package com.softserve.atqc;

import java.text.MessageFormat;

/**
 * Class provides functionality to express value into sum of two squares.
 * @version 02.02.2017
 */
public class CalculateResult {
    /**
     * Message shown in case of success ability to represent message.
     */
	private String successAbilityMessage = "Input valule could be expressed as "
	        + "summ of squares.";
	/**
     * Message shown in case of fail ability to represent message.
     */
	private String failAbilityMessage = "Input valule couldn't be expressed as "
	        + "summ of squares.";
	
	/**
     * Results header message.
     */
	private String allResultsHeaderMessage = "All results: ";

	/**
     * Calculates and prints all groups of values that user value can be
     * represented.
     * @param value integer value read and parsed from console
     */
	public final void totalExpressValue(final int value) {
		printAllResultsHeader();
		int countOfResults = 0;
		for (int x = 1; x < value; x++) {
			for (int y = 1; y < value; y++) {
				if (x * x + y * y == value) {
					countOfResults++;
					printRepresentResults(x, y);
				}
			}
		}
		printCounOfResultPairs(countOfResults);
	}

	/**
     * Calculates and prints first group of values that user value can be
     * represented.
     * 
     * @param value integer value read and parsed from console
     * @return true if there is at least one result of calculations
     * and false - if not.
     */
	public final boolean oneResultExpressValue(final int value) {
		for (int x = 1; x < value; x++) {
			for (int y = 1; y < value; y++) {
				if (x * x + y * y == value) {
					System.out.println(successAbilityMessage);
					printOneRepresentResult(x, y);
					return true;
				}

			}
		}
		System.out.println(failAbilityMessage);
		return false;
	}

	 /**
     * Prints message before all results.
     */
	private void printAllResultsHeader() {
		System.out.println(allResultsHeaderMessage);
	}

	 /**
     * Prints formatted count or result groups of calculated parameters.
     * 
     * @param count of groups.
     */
	private void printCounOfResultPairs(final int count) {
		String message = MessageFormat.format("Count of result pairs: {0}", 
		        count);
		System.out.println(message);
	}

	/**
     * Prints formatted result of representing value.
     * @param x integer value to print as "x" to console
     * @param y integer value to print as "y" to console
     */
	private void printOneRepresentResult(final int x, final int y) {
		String message = MessageFormat.format("At least one result: x = {0}, "
		        + "y = {1};", x, y);
		System.out.println(message);
	}

	/**
     * Prints formatted results of representing value.
     * @param x integer value to print as "x" to console
     * @param y integer value to print as "y" to console
     */
	private void printRepresentResults(final int x, final int y) {
		String message = MessageFormat.format("x = {0}, y = {1};", x, y);
		System.out.println(message);
	}
}
