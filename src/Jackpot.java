import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Jackpot {

	private static final BigInteger BILLION = new BigInteger("1000000000");
	
	public static void main(final String[] args) {
		try (final Scanner in = new Scanner(System.in)) {
			final int machines = in.nextInt();
			for (int i = 0; i < machines; i++) {
				final BigInteger[] numbers = new BigInteger[in.nextInt()];
				for (int j = 0; j < numbers.length; j++) {
					numbers[j] = BigInteger.valueOf(in.nextLong());
				}
				
				final BigInteger lcm = lcm(numbers);
				if (BILLION.compareTo(lcm) < 0) {
					System.out.println("More than a billion.");
				} else {
					System.out.println(lcm);
				}
			}
		}
	}
	
	private static BigInteger lcm(final BigInteger[] numbers) {
		if (numbers.length == 1) {
			return numbers[0];
		} else if (numbers.length == 2) {
			return (numbers[0].multiply(numbers[1])).divide(gcd(numbers));
		} else {
			return lcm(new BigInteger[] { numbers[0], lcm(Arrays.copyOfRange(numbers, 1, numbers.length)) });
		}
	}
	
	private static BigInteger gcd(final BigInteger... numbers) {
		return (numbers[1].equals(BigInteger.ZERO)) ? numbers[0]: gcd(numbers[1], numbers[0].mod(numbers[1]));
	}
}
