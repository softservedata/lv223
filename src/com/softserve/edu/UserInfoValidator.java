package com.softserve.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class provides functionality to read and validate user info.
 * @version 02.02.2017
 */
public class UserInfoValidator {
    
    /**
     * Header message.
     */
	private static String headerInfo = "Please, enter value:\n(Or press \"q\" to exit)";
    /**
     * Message, that appears when incorrect data typed.
     */
	private static String failMessage = "Incorrect value. Please, try again.";
    /**
     * Instance of reader, is used to read data from console.
     */
	private BufferedReader reader;
	
    /**
     * Includes parsed to Number data from console.
     */
	private int userNumber;

    /**
     * Constructor of class, initializing instance of BufferedReader
     * to read data from console.
     */
	public UserInfoValidator() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
     * Getter for parsedNumber.
     * @return integer value of user number.
     */
	public final int getUserNumber() {
		return userNumber;
	}
	
    /**
     * Reads user value from console.
     * @return String value from console input
     */
	public final String getUserValue() {
		System.out.println(headerInfo);
		String userInfo = null;
		try {
			userInfo = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
    /**
     * Parse user value from string to integer.
     * @param info read from console
     * @return true if info successfully parsed and false if not
     */
	public final boolean checkIsDigit(final String info) {
		try {
			userNumber = Integer.valueOf(info.trim());
			return true;
		} catch (NumberFormatException e) {
			System.out.println(failMessage);
		}
		return false;
	}

    /**
     * Validates value from console.
     * @param value from console
     * @return true if value is valid, false if not
     */
	public final boolean validateStringValue(final String value) {
		if (value.trim().equalsIgnoreCase("Q")) {
			System.exit(0);
		} else if (value.equals("")) {
			System.out.println(failMessage);
			return false;
		} else if (!checkIsDigit(value)) {
			return false;
		}
		return true;
	}
	
	 /**
     *  Validates if parsed to integer data from console is natural number
     *  @param value from console
     *  @return true if natural number, false if not
     */
	public final boolean validateDigitValue(final int value) {
		if (value > 0) {
			return true;
		} else {
			System.out.println(failMessage);
			return false;
		}
	}
}

