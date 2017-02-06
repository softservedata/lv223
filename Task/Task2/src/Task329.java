
import java.util.Scanner;

 class Task329 {
	

		public static void main(String args[]) {
		//System.out.println("Vvedit chuslo n ->");
		//Scanner sc=new Scanner (System.in);
		//int n=sc.nextInt();
		//System.out.println("Vvedit chuslo m ->");
		//int m=sc.nextInt();
		for(int n=10;n<100;n++){
			for(int m=10;m<100;m++){
	if ( n < m ) {		
		int d = n /10;	
		int f=n%10;
		//for(int q=1;q<1000;q++)	{
		if (m == (d * d) + (f * f)) {
			//System.out.println(d);
			//System.out.println(f);
			System.out.println(m);
		}
		}
			}
			}
		}
	}


