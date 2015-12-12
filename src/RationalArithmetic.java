import java.math.BigInteger;
import java.util.Scanner;

public class RationalArithmetic {

	public static void main(final String[] args) {
		try (final Scanner in = new Scanner("1 -1 2 * -1 2")) {
			final int cases = in.nextInt();
			for (int i = 0; i < cases; i++) {
				final BigInteger x1 = BigInteger.valueOf(in.nextLong()), 
						         y1 = BigInteger.valueOf(in.nextLong());
				
				final char op = in.next().charAt(0);
				final BigInteger x2 = BigInteger.valueOf(in.nextLong()), 
						         y2 = BigInteger.valueOf(in.nextLong());
				
				final BigInteger y3 = (op == '/') ? x2.multiply(y1) : y2.multiply(y1);
				final BigInteger x3 = op(x1, y1, op, x2, y2);
				
				final BigInteger gcd = gcd(x3, y3);
				final BigInteger y4 = (gcd.equals(BigInteger.ZERO)) ? BigInteger.ZERO : y3.divide(gcd);
				final BigInteger x4 = (gcd.equals(BigInteger.ZERO)) ? BigInteger.ZERO : x3.divide(gcd);
				
				if (y4.compareTo(BigInteger.ZERO) < 0) {
					System.out.println(x4.negate() + " / " + y4.negate());
				} else {
					System.out.println(x4 + " / " + y4);
				}
			}
		}
	}

	private static BigInteger op(
							final BigInteger x1, 
							final BigInteger y1, 
							final char op, 
							final BigInteger x2, 
							final BigInteger y2) {
		switch(op) {
			case '*' : return x1.multiply(x2); 
			case '/' : return x1.multiply(y2);
			case '+' : return x1.multiply(y2).add(x2.multiply(y1));
			default  : return x1.multiply(y2).subtract(x2.multiply(y1));
		}
	}
	
    private static BigInteger gcd(final BigInteger a, final BigInteger b) {
    	if (a.compareTo(BigInteger.ZERO) < 0) return gcd(a.negate(), b);
    	if (b.compareTo(BigInteger.ZERO) < 0) return gcd(a, b.negate());
        return (b.equals(BigInteger.ZERO)) ? a: gcd(b, a.mod(b));
    }
}
