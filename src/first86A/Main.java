package first86A;

/*
 * Main class
 */
public class Main {
/*
 * main method
 */
	public static void main(String[] args) {
		Input input = new Input();
		int number = input.EnterValue();
		int k = 0;
		do
		{
			number = number / 10;
			k ++;
		}
		while(number != 0);
		System.out.println("Your number has " +k+ " characters");
	}

}
