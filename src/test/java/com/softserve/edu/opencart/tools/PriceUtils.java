package com.softserve.edu.opencart.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceUtils {
    
    private static final String PRICE_DIGIT_PATTERN = "\\d+\\.\\d+";
    private static final String PRICE_CURRENCY_PATTERN = "(\\p{Sc})";
    private static final String NO_MATCH_FOUND_ERROR_MESSAGE = "No Match Found";
    
    private PriceUtils() {
    }

    public static int getDigitPrice(String text) {
        return Integer.parseInt(getStringPrice(text));
    }

    public static String getStringPrice(String text) {
        Pattern pattern = Pattern.compile(PRICE_DIGIT_PATTERN);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) {
            throw new GeneralException(NO_MATCH_FOUND_ERROR_MESSAGE);
        }
        return text.substring(matcher.start(), matcher.end());
    }
    
    public static String getCurrencySymbol(String text) {
        Pattern pattern = Pattern.compile(PRICE_CURRENCY_PATTERN);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) {
            throw new GeneralException(NO_MATCH_FOUND_ERROR_MESSAGE);
        }
        return text.substring(matcher.start(), matcher.end());
    }
    

}
