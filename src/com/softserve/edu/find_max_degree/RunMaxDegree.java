package com.softserve.edu.find_max_degree;

import com.softserve.edu.UserInfoValidator;
import com.softserve.edu.ConsoleOutput;

/**
 * Class interacts with user through console and initialize calculation of
 * maximum degree.
 * @version 02.02.2017
 */
public class RunMaxDegree {

    private ConsoleOutput toConsole;
    private UserInfoValidator userInfo;
    private CalculationMaxDegree calc;

    public RunMaxDegree(){
        toConsole = new ConsoleOutput();
        userInfo = new UserInfoValidator();
        calc = new CalculationMaxDegree();
    }
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
                toConsole.printResult(result);
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
        RunMaxDegree interact = new RunMaxDegree();
        interact.interact();
    }

}
