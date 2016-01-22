import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.min;
import static java.lang.Math.max;

import java.util.Scanner;

public class Base2Palindrome {

    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            System.out.println(binaryPalindrome(in.nextInt()));
        }
    }

    private static long binaryPalindrome(final int index) {
        return (index < 3) ? A006995(index - 1) : A006995(index + 1);
    }

    private static long A006995(final int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 3;
        } else if (n == 2) {
            return 5;
        } else {
            final long m = (long) floor(log(n) / log(2));
            final double a = pow(2, 2 * m - 2) + 1;
            final double b = a + 2 * floor((n - pow(2, m)) / pow(2, m - 1));
            final double c = b + pow(2, m - 1) * floor(0.5d * min(n + 1 - pow(2, m), pow(2, m - 1) + 1));
            final double d = c + 3 * pow(2, m - 1) * floor(0.5d * max(n + 1 - 3 * pow(2, m - 1), 0));

            long sum = 0;
            for (int j = 2; j < m; j++) {
                sum += floor((n + pow(2, j - 1) - pow(2, m)) / pow(2, j)) * pow(2, m - j);
            }

            return (long) d + 3 * sum;
        }
    }
}