package zd1;

import java.util.Scanner;

public class zd3 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int	n = sc.nextInt();
		int k = 0 ;
		for (int i = 1; i<n; i++){
			 k = (int)( Math.pow(2, i)-1);
			 if (k < n){
				System.out.println("K= " +k);
			}
	}

	}
	
	

}
