
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package com.softserve.edu;

import java.util.ArrayList;

/**
 * Returns the natural divisors of n.
 */

public class NaturalDivisors {

    NaturalDivisors() {
        System.out.println("Natural Divisors:");
    }

    public final ArrayList<Integer> func(final int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                System.out.print(i + " ");
                list.add(i);
            }
        }
        return list;
    }
}
