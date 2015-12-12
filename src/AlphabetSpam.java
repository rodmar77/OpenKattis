import java.util.Scanner;

public class AlphabetSpam {

	public static void main(final String[] args) throws Exception {
		try (final Scanner in = new Scanner(System.in)) {
			final double[] totals = { 0, 0, 0, 0 };
			final String line = in.nextLine();
			for (int i = 0; i < line.length(); i++) {
				final char c = line.charAt(i);
				if (c == '_') {
					totals[0]++;
				} else if (Character.isAlphabetic(c)) {
					if (Character.isLowerCase(c)) {
						totals[1]++;
					} else {
						totals[2]++;
					}
				} else {
					totals[3]++;
				}
			}
			
			for (final double total : totals) {
				System.out.println(total / line.length());
			}
		}
	}
}
