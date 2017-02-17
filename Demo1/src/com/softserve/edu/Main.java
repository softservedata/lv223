
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package com.softserve.edu;

import java.util.Random;

public class Main {
    public static void main(final String[] args) {

       /*
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter n:");

       if(scan.hasNextInt()){
           n = scan.nextInt();
       }
       */

        Random rand = new Random();
        int n = rand.nextInt(100); // random value for n from 0 to 1000
        System.out.println("n = " + n);

        NaturalDivisors nat = new NaturalDivisors();
        nat.func(n);  //calling a function to find natural divisors of n
        System.out.println();

        PrimeDivisors sim = new PrimeDivisors();
        sim.func(76); //calling a function to find prime divisors of n

        System.out.println();

        SameLastDigits same = new SameLastDigits();
        same.func(99); //calling a function to find same last digits from 1 to n

    }
}


