import java.util.Scanner;
import static java.lang.Math.*;
public class Task562 {
	public static void main(String args[]) {
	        System.out.println("Vvedit chuslo n ->");
			Scanner sc=new Scanner (System.in);
			int n=sc.nextInt();
			
	String str=Integer.toString(n);
	int m=str.length();
	 System.out.println(m);
	 
switch(m)	 {
case 2 :
	{int d=n/10;	
	int f=n%10;
    if(n==pow(d,2)+pow(f,2) )	{System.out.println(n);}
	System.out.println(" digit 2");
	break;}
case 3 : 
	{int j=n/100;//1
	//System.out.println(j);
	int s=n%100;//011
	//System.out.println(s);
	int h=s/10;//2
	//System.out.println(h);
	int w=s%10;//3
	//System.out.println(w);
   if(n==pow(j,3)+pow(h,3)+pow(w,3) )	
	   System.out.println(n);
	//System.out.println("chuslo 3"); 
break;}
case 4 : 
	{int i=n/1000;//1
	int q=n%1000;//0111
	int u=q/100;//2
	int y=q%100;//0011
	int o=y/10;//3
	int p=y%10;//4
   if(n==pow(i,4)+pow(u,4)+pow(o,4)+pow(p,4) )	{System.out.println(n);}
	System.out.println("chuslo 4"); 
break;}
}
}



	}