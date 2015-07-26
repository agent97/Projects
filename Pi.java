/**
 * Created by agent97 on 7/24/2015.
 */
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Pi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("This program will calculate Pi to up to 330 digits.");
        System.out.print("How many digits would you like? ");
        int d = in.nextInt();
        System.out.println("Pi (" + d + " digits): " + calcPi(d));
    }

    /*
        The algorithm in the following method is based on the following equation for Pi
        (Known as the BBP Formula)

            Pi = SUM(k=0 to infinity) 16^(-k) [ 4/(8k+1) - 2/(8k+4) - 1/(8k+5) - 1/(8k+6) ]

        Copied from https://www.math.hmc.edu/funfacts/ffiles/20010.5.shtml on 7/24/15
    */
    private static BigDecimal calcPi(int digits) {
        BigDecimal pi = new BigDecimal(0);
        MathContext mc = new MathContext(digits);

        for(int i = 0; i <= digits; i++) {
            BigDecimal k = new BigDecimal(i * 8);
            pi = pi.add(new BigDecimal((Math.pow(16, (i*-1)))).multiply(
                    (new BigDecimal(4).divide(k.add(new BigDecimal(1)), mc)).subtract(
                    (new BigDecimal(2).divide(k.add(new BigDecimal(4)), mc))).subtract(
                            (new BigDecimal(1).divide(k.add(new BigDecimal(5)), mc))).subtract(
                    (new BigDecimal(1).divide(k.add(new BigDecimal(6)), mc)))));
        }

        return pi.round(new MathContext(digits));
    }

}
