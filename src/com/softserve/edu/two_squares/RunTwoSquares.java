package com.softserve.edu.two_squares;

import com.softserve.edu.UserInfoValidator;

/**
 * Class interacts with user through console and represents
 * user value into sum of two squares.
 * @version 02.02.2017
 */
public class RunTwoSquares {
    /**
     * Instance on UserInfoValidator class.
     */
    private UserInfoValidator userInfo;
    /**
     * Instance of CalculateResult class.
     */
    private CalculationTwoSquares calc;
    /**
     * Constructor initializing instances of UserInfoValidator and CalculateResult
     * classes.
     */
    public RunTwoSquares(){
        userInfo = new UserInfoValidator();
        calc = new CalculationTwoSquares();
    }
    /**
     * Takes userNumber from console, represents number into three squares and
     * prints into console. Works until user type "q".
     */   
    public void interact() {
        while (true) {
            String userValue = userInfo.getUserValue();
            if (!userInfo.validateStringValue(userValue)) {
                continue;
            }
            int parsedValue = userInfo.getUserNumber();
            if (userInfo.validateDigitValue(parsedValue)) {
                if (calc.oneResultExpressValue(parsedValue)) {                    
                    calc.totalExpressValue(parsedValue);
                }
            } else {
                continue;
            }
        }
    }
    /**
     * Main method.
     * @param args from console
     */
    public static void main(String[] args) {
        RunTwoSquares run = new RunTwoSquares();
        run.interact();
    }
}
