package com.softserve.edu.three_squares;

import com.softserve.edu.UserInfoValidator;
/**
 * Class interacts with user through console and represents
 * user value into sum of three squares.
 * @version 02.02.2017
 */
public class RunThreeSquaresCalc {

    /**
     * Instance on UserInfoValidator class.
     */
    private UserInfoValidator userInfo = new UserInfoValidator();
    
    /**
     * Instance of CalculateResult class.
     */
    private CalculationThreeSquares calc = new CalculationThreeSquares();

    /**
     * Takes userNumber from console, represents number into three squares and
     * prints into console. Works until user type "q".
     */
    public final void interact() {
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
        
        RunThreeSquaresCalc run = new RunThreeSquaresCalc();
        run.interact();
    }

}
