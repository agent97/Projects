/**
 * Created by agent97 on 7/26/2015.
 */
import java.util.Scanner;

public class CollatzConjecture {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("This project: Collatz Conjecture - Start with a number n > 1. Find the" +
                " number of steps it takes to reach one using the following process: If n is even, " +
                "divide it by 2. If n is odd, multiply it by 3 and add 1.");
        System.out.print("Enter a number greater than one: ");
        int n = in.nextInt();

        System.out.println("Conjecture reached 1 in " + collatz(n) + " steps.");
    }

    private static int collatz(int n) {
        int steps = 0;

        while(n != 1) {
            if(n % 2 == 0) n /= 2;
            else n = (n * 3) + 1;
            steps++;
        }

        return steps;
    }

}
