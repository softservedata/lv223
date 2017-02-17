
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package com.softserve.edu;

import java.util.ArrayList;

/**
 * Does searching the same last digits from 0 to n.
 */

public class SameLastDigits {


    SameLastDigits() {
        System.out.println("Same last digits: ");
    }

    public final ArrayList<Integer> func(final int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (i == ((i * i)
                    % (int) (Math.pow(10, Math.floor(Math.log10(i)) + 1)))) {
                list.add(i);
                System.out.print(i + " ");
            }
        }
        return list;

    }
}
