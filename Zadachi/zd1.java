package zd1;

import java.util.Scanner;

public class zadacha_one {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = n;
		int m = sc.nextInt();
		int t=0;
		int s =0;
		while ( k>1){
			t++;
			k = k/10;	
		}
		if (m <=t) {
			int i = 1;
			    while (i <=m) {
			        int a = n%10;
			        n = n/10;       
			        s = s + a;
			        i++;
			    }}else {System.out.println("error!");}
		
		System.out.println(s);
	
	}}

