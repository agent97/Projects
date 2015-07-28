/**
 * Created by agent97 on 7/28/2015.
 */
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("This project generates numbers in the " +
                "Fibonacci Sequence. These numbers exceed int bounds after 46th iteration.");
        System.out.print("How many steps of the Fibonacci Sequence would you like to generate (0 < n < 47)? ");
        int n = in.nextInt();

        fibonacci(n);
    }

    private static void fibonacci(int n) {
        int a = 1, b = 1;
        double max = Math.pow(2, 31) - 1;

        if(n <= 0) System.out.println(n + " is less than zero. Please enter a number between 0 and 47.");
        if(n > 46) System.out.println(n + " is greater than 46. Please enter a number between 0 and 47.");
        else {
            System.out.println("1: 1");
            for(int i = 1; i < n; i++) {
                System.out.println((i + 1) + ": " + a);
                int hold = a;
                a += b;
                b = hold;
            }
        }
    }

}
