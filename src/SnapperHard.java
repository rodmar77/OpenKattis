import java.util.Scanner;

public class SnapperHard {

	public static void main(final String[] args) {
		try (final Scanner in = new Scanner(System.in)) {
			final int cases = in.nextInt();
			for (int i = 0; i < cases; i++) {
				System.out.println("Case #" + (i + 1) + ": " + f(in.nextInt(), in.nextInt() + 1));
			}
		}
	}

	private static String f(final int n, final int k) {
		boolean allOn = true;
		for (int index = 1; ((allOn) && (index <= n)); index++) {
			final int n2 = 1 << index, n2m1 = 1 << (index - 1);
			allOn &= ((k % n2) == 0) || ((k % n2) > n2m1);
		}
		
		return (allOn) ? "ON" : "OFF";
	}
	
}