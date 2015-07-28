/**
 * Created by agent97 on 7/28/2015.
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Factorizer {
    private ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
    private ArrayList<BigInteger> factors = new ArrayList<BigInteger>();

    public static void main(String[] args) {
        Factorizer f = new Factorizer();
        f.primes.add(new BigInteger("2"));

        System.out.print("Enter an integer: ");
        BigInteger n = new BigInteger("" + (new Scanner(System.in)).nextInt());

        System.out.println("The next prime number after " + n + " is " +
                f.nextPrime(new BigInteger("" + n)));
        System.out.println("The prime factors of " + n + " are " + f.factor(n));
    }

    public String factor(BigInteger n) {
        if(isPrime(n)) return "[1, " + n + "]";

        String ret = "[1, ";

        for(int i = 0; i < primes.size(); i++) {
            BigInteger check = primes.get(i);
            if(check.compareTo(n) <= 0) {
                while(n.remainder(check) == BigInteger.ZERO) {
                    ret += check + ", ";
                    n = n.divide(check);
                }
            }
        }

        return ret.substring(0, ret.length() - 2) + "]";
    }

    public BigInteger nextPrime(BigInteger current) {
        if(isPrime(current)) current = current.add(BigInteger.ONE);
        BigInteger past = primes.get(primes.size() - 1).add(BigInteger.ONE);

        while(past.compareTo(current) < 0) {
            BigInteger next = next(past);
            primes.add(next);
            if(next.compareTo(past) > 0) past = next;
            else past = past.add(BigInteger.ONE);
        }

        if(past.compareTo(current) > 0) return past;

        return next(past);
    }

    private BigInteger next(BigInteger current) {
        while(!isPrime(current)) {
            current = current.add(BigInteger.ONE);
        }
        return current;
    }

    private boolean isPrime(BigInteger check) {
        if(primes.indexOf(check) != -1) return true;

        for(int i = 0; i < primes.size(); i++) {
            if(check.remainder(primes.get(i)).compareTo(BigInteger.ZERO) == 0) return false;
        }
        primes.add(check);

        return true;
    }
}
