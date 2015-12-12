import java.util.Scanner;

public class Tajna {
	public static void main(final String[] args) {
		try (final Scanner in = new Scanner(System.in)) {
			final String text = in.nextLine();
			final int[] data = getDataFor(text);
			
			final char[][] encrypted = new char[data[0]][data[1]];
			
			for (int j = 0, index = 0; index < text.length(); j++) {
				for (int i = 0; (index < text.length()) && (i < encrypted.length); i++, index++) {
					encrypted[i][j] = text.charAt(index);
				}
			}
			
			for (int i = 0, index = 0; index < text.length(); i++) {
				for (int j = 0; (index < text.length()) && (j < encrypted[i].length); j++, index++) {
					System.out.print(encrypted[i][j]);
				}
			}
			
			System.out.println();
		}
	}

	private static int[] getDataFor(final String text) {
		int maxRow = 0;
		for (int row = 1; row <= text.length() / 2; row++) {
			if (((text.length() % row) == 0) && ((text.length() / row) >= row)) {
				maxRow = row;
			}
		}
		
		return new int[] { maxRow, text.length() / maxRow };
	}
}
