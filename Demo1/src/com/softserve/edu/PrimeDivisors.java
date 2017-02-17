
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package com.softserve.edu;

import java.util.ArrayList;

/**
 * Returns the prime divisors of n.
 */


public class PrimeDivisors {

    PrimeDivisors() {
        System.out.println("Prime Divisors:");
    }

    private boolean checkPrime(final int n) {

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false; 
            }

        }

        return true;
    }

    public final ArrayList<Integer> func(final int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (((n % i) == 0) && checkPrime(i)) {
                System.out.print(i + " ");
                list.add(i);
            }
        }
        return list;

    }
}
