package zd1;

import java.util.Scanner;

public class zd2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int	n = sc.nextInt();
		int	m = sc.nextInt();
		if (n ==0 && m == 0){
			    System.out.println("Error!");
		} else {
			for (int i = 1; i < n*m; i++){
				if (n % i == 0 && m % i == 0){System.out.println(i);}
			}
		} 
		

	}

}
