import java.math.BigInteger;
import java.util.Scanner;

public class ModularArithmetic {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            BigInteger n;
            int t;

            do {
                n = new BigInteger(in.next());
                t = in.nextInt();
                for (int i = 0; i < t; i++) {
                    final BigInteger x = new BigInteger(in.next());
                    final char op = in.next().charAt(0);
                    final BigInteger y = new BigInteger(in.next());

                    System.out.println(getResult(x, y, op, n));
                }
            } while ((t > 0) && (!n.equals(BigInteger.ZERO)));
        }
    }

    private static BigInteger getResult(final BigInteger x, final BigInteger y, final char op, final BigInteger n) {
        final BigInteger minusOne = new BigInteger("-1");

        try {
            switch (op) {
                case '-' : return x.subtract(y).mod(n);
                case '+' : return x.add(y).mod(n);
                case '*' : return x.multiply(y).mod(n);
                default  : return (x.mod(n).multiply(y.modPow(minusOne, n))).mod(n);
            }
        } catch (final ArithmeticException e) {
            return minusOne;
        }
    }
}
