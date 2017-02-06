package testPackage;

/**
 * @author Anna Orlovska
 *
 */
class App {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.printf("Result is %f", calculator.getElementN(0));
		System.out.println("\nResult is "+ calculator.getElem(10));
		
		int[] array = calculator.randomArray(6);
		calculator.printArray(array);
		System.out.println("\n" + calculator.isElementPositive(array));
	}
}
