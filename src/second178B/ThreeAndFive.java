package second178B;

import java.util.Scanner;

public class ThreeAndFive {
	public int HowMuchNumbers(){
		int firstValue = 0;
		int secondValue = 0;
		int step = 0;
		
		System.out.println("Enter the start value");
		
		do
		{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt())
			{
				firstValue = sc.nextInt();
			}
			else {
				System.out.println("Please enter number");
				 }
		} 
		while(firstValue == 0);
		
		System.out.println("Enter finish value");
		
		do
		{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt())
			{
				secondValue = sc.nextInt();
			}
			else {
				System.out.println("Please enter number");
				 }
		} 
		while(secondValue == 0);
		
		System.out.println("Enter step");
		
		do
		{
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt())
			{
				step = sc.nextInt();
			}
			else {
				System.out.println("Please enter number");
				 }
		} 
		while(step == 0);
		
		int k = 0;
		
		for(int i = firstValue;i<secondValue;i+=step)
		{
			if((i %  3 == 0) && (i % 5 != 0))
			{
				k++;
			}
		}
		
		return k;
	}

}
