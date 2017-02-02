
/**
 * Created by Artem Redchyts on 01.02.2017.
 */

package tasks;

/**
 * Does searching the same last digits from 0 to n.
 */

public class SameLastDigits {


    SameLastDigits() {
        System.out.println("Same last digits: ");
    }

    public void Func(int n) {

        for (int i = 1; i <= n; i++) {
            if (i == ((i * i)
                    % (int) (Math.pow(10, Math.floor(Math.log10(i)) + 1)))) {
                System.out.print(String.valueOf(i + " "));
            }
        }

    }
}
