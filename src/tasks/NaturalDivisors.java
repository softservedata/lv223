
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package tasks;

/**
 * Returns the natural divisors of n.
 */

public class NaturalDivisors {

    NaturalDivisors() {
        System.out.println("Natural Divisors:");
    }

    public void Func(int n) {

        for (int i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                System.out.print(i + " ");

            }
        }
    }
}
