import java.util.Scanner;

public class FractionalLotion {

	public static void main(final String[] args) {
		try (final Scanner in = new Scanner(System.in)) {
			final int n = Integer.parseInt(in.next().substring(2));
			
			int count = 0;
			for (long x = n + 1; x <= 2*n; x++) {
				if (n*x % (x - n) == 0) {
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}