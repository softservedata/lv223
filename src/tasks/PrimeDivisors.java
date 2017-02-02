
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package tasks;

/**
 * Returns the prime divisors of n.
 */

public class PrimeDivisors {

    PrimeDivisors() {
        System.out.println("Prime Divisors:");
    }

    private boolean CheckPrime(int n) {

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }

        }

        return true;
    }

    public void Func(int n) {

        for (int i = 1; i <= n; i++) {
            if (((n % i) == 0) && CheckPrime(i)) {
                System.out.print(i + " ");
            }

        }

    }
}
