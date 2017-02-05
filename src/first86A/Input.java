package first86A;


import java.util.Scanner;
/*
 * Input method
 */
public class Input {
	public final int EnterValue () {
		int length = 0;
		System.out.println("Enter n");
	do
	{
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt())
		{
			length = sc.nextInt();
		}
		else {
			System.out.println("Please enter number");
			}
	} 
	while(length == 0);
	return length;
	}
}
