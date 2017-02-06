package com.softserve.atqc;

/**
 * Class interacts with user through console and initialize calculation of
 * maximum degree.
 * @version 02.02.2017
 */
public class Main {

    /**
     * Instance on UserInfo class.
     */
    private UserInfo userInfo = new UserInfo();
    /**
     * Instance of CalculateResult class.
     */
    private CalculateResult calc = new CalculateResult();

    /**
     * Takes userNumber from console, calculates maximum degree of number and
     * prints it to console. Works until user not type "q".
     */
    public final void interact() {
        while (true) {
            String userValue = userInfo.getUserValue();
            if (!userInfo.validateStringValue(userValue)) {
                continue;
            }

            int parsedValue = userInfo.getUserNumber();
            if (userInfo.validateDigitValue(parsedValue)) {
                int result = calc.getMaxDegree(parsedValue);
                userInfo.printResult(result);
            } else {
                continue;
            }
        }
    }

    /**
     * Main method.
     * @param args from console
     */
    public static void main(final String[] args) {
        Main main = new Main();
        main.interact();
    }
}
