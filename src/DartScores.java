import java.util.Scanner;

public class DartScores {

	public static void main(final String[] args) {
		try (final Scanner in = new Scanner(System.in)) {
			final int cases = in.nextInt();
			for (int i = 0; i < cases; i++) {
				final int dartThrows = in.nextInt();
				int score = 0;
				for (int j = 0; j < dartThrows; j++) {
					score += getScore(in.nextInt(), in.nextInt());
				}
				
				System.out.println(score);
			}
		}
	}

	private static int getScore(final int x, final int y) {
		final double r = Math.sqrt((x*x) + (y*y));
		for (int p = 10; p > 0; p--) {
			if (r <= 20 * (11 - p)) {
				return p;
			}
		}

		return 0;
	}
}
