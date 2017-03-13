package com.softserve.edu.opencart.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CountUtils {

	private static final String TEXT_IN_BRACKETS_PATTERN = "\\(\\d+\\)";
	private static final String NO_MATCH_FOUND_ERROR_MESSAGE = "No Match Found";

	private CountUtils() {
	}

	public static int getCountInBrackets(String text) {
		return Integer.parseInt(getTextInBrackets(text));
	}

	public static String getTextInBrackets(String text) {
		Pattern pattern = Pattern.compile(TEXT_IN_BRACKETS_PATTERN);
		Matcher matcher = pattern.matcher(text);
		if (!matcher.find()) {
			throw new GeneralException(NO_MATCH_FOUND_ERROR_MESSAGE);
		}
		//System.out.println(text.substring(matcher.start(), matcher.end()));
		return text.substring(matcher.start() + 1, matcher.end() - 1);
	}

}
