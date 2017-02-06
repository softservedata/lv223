package SummOfThreeSquares.src.com.softserve.atqc;

/**
 * Class interacts with user through console and represents
 * user value into sum of three squares.
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
	public static void main(final String[] args) {
		Main main = new Main();
		main.interact();
	}
}