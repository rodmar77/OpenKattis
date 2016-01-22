import static java.math.BigInteger.ONE;
import java.math.BigInteger;
import java.util.Scanner;

public class BestCompression {

    private static final BigInteger TWO = new BigInteger("2");

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final BigInteger n = new BigInteger(in.next());
            final BigInteger b = sumOfPowers(in.nextInt());
            System.out.println((b.compareTo(n) < 0) ? "no" : "yes");
        }
    }

    private static BigInteger sumOfPowers(final int currentPower) {
        return TWO.pow(currentPower + 1).subtract(ONE);
    }
}