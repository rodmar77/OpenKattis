import java.util.Scanner;

public class PermutationEncryption {

	public static void main(String[] args) throws Exception {
		try (final Scanner in = new Scanner(System.in)) {
			int length;
			while ((length = in.nextInt()) != 0) {
				final int[] permutation = getPermutation(in, length);
				final String line = getNextLine(in, length);
				System.out.println(permute(line, permutation));
			}
		}
	}

	private static String permute(final String line, final int[] permutations) {
		final StringBuilder result = new StringBuilder("'");
		for (int i = 0; i < line.length(); i += permutations.length) {
			for (final int permutation : permutations) {
				result.append(line.charAt(i + permutation - 1));
			}
		}

		result.append("'");
		return result.toString();
	}

	private static String getNextLine(final Scanner in, final int length) {
		final StringBuilder result = new StringBuilder();
		result.append(in.nextLine()).append(in.nextLine());
		while ((result.length() % length) > 0) {
			result.append(' ');
		}
		
		return result.toString();
	}

	private static int[] getPermutation(final Scanner in, final int length) {
		final int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = in.nextInt();
		}
		
		return result;
	}
}
