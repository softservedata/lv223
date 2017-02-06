import java.util.Scanner;

/*
 * @version
 * @author
 */
public class Task225 {
    /*
     *
     */
    public static void main(String args[]) {
        int number;
        Scanner sr = new Scanner(System.in);
        System.out.println("Vvedit chuslo ->");
        if (sr.hasNextInt()) {
            number = sr.nextInt();
            for (int q = 1; q < 1000; q++) {
                if (number % (q * q) == 0 && number % (q * q * q) != 0) {
                    System.out.println(q);
                }
            }
        }
    }
}
