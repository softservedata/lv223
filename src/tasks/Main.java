
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package tasks;

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
        int n = rand.nextInt(100) + 1; // random value for n from 1 to 100
        System.out.println("n = " + n);

        NaturalDivisors nat = new NaturalDivisors();
        nat.Func(n);

        System.out.println();

        PrimeDivisors sim = new PrimeDivisors();
        sim.Func(n);

        System.out.println();

        SameLastDigits same = new SameLastDigits();
        same.Func(n);

    }
}


