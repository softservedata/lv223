package com.softserve.edu.opencart.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CountUtils {

	private static final String TEXT_IN_BRACKETS_PATTERN = "\\(\\d+\\)";
	private static final String TEXT_IN_PRICE_PATTERN = "\\d+\\.\\d+";
	private static final String NO_MATCH_FOUND_ERROR_MESSAGE = "No Match Found";

	private CountUtils() {
	}

	public static int getCountInBrackets(String text) {
		return Integer.parseInt(getTextInBrackets(text));
	}

	public static double getPriceInText(String text) {
		return Double.parseDouble(getTextPriceValue(text));
	}

	private static String getTextByRegex(String text, String patternText, int correction) {
		Pattern pattern = Pattern.compile(patternText);
		Matcher matcher = pattern.matcher(text);
		if (!matcher.find()) {
			throw new GeneralException(NO_MATCH_FOUND_ERROR_MESSAGE);
		}
		//System.out.println(text.substring(matcher.start(), matcher.end()));
		return text.substring(matcher.start() + correction, matcher.end() - correction);
		
	}
	
	public static String getTextInBrackets(String text) {
		return getTextByRegex(text, TEXT_IN_BRACKETS_PATTERN, 1);
	}

	public static String getTextPriceValue(String text) {
		return getTextByRegex(text, TEXT_IN_PRICE_PATTERN, 0);
	}

}
