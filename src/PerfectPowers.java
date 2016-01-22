import static java.lang.Math.pow;
import java.util.Scanner;

public class PerfectPowers {

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            long value;
            while ((value = in.nextLong()) > 0) {
                System.out.println(largestPower(value));
            }
        }
    }

    private static int largestPower(final long value) {
        if (isPrime(value)) {
            return 1;
        }

        for (int i = 64; i > 0; i--) {
            final long base = (long) Math.pow(value, 1d / i);
            if (((long) pow(base, i)) == value) {
                return i;
            }
        }

        return 1;
    }

    public static boolean isPrime(final long number) {
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        } else if ((number % 2) == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                if ((number % i) == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}