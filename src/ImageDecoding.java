import java.util.Scanner;

public class ImageDecoding {

	public static void main(final String[] args) throws Exception {
		try (final Scanner in = new Scanner("12\n# 8 2 4 4 3\n. 1 2 4 2 2 2 6 1 1\n. 1 2 5 2 1 2 6 1 1\n. 1 2 5 1 2 2 6 1 1\n. 1 2 4 2 2 2 6 1 1\n. 1 7 3 2 6 1 1\n. 1 2 4 2 2 2 6 1 1\n. 1 2 5 2 1 2 6 1 1\n. 1 2 5 2 2 2 5 1 1\n. 1 2 5 2 2 2 4 2 1\n. 1 2 4 2 4 2 3 1 2\n# 7 8 2 4\n35\n. 11 7 12\n. 10 10 10\n. 10 10 10\n. 9 12 9\n. 9 12 9\n. 9 12 9\n. 9 12 9\n. 9 12 9\n. 9 4 1 7 9\n. 9 2 5 5 9\n. 10 12 8\n. 10 12 8\n. 9 7 2 5 7\n. 8 3 1 3 3 6 6\n. 7 3 9 5 7\n. 7 3 9 6 5\n. 6 4 9 7 4\n. 6 4 10 6 4\n. 5 4 11 7 3\n. 5 4 12 6 3\n. 4 4 13 6 3\n. 4 4 13 6 3\n. 4 4 13 6 3\n. 4 4 13 6 3\n. 4 4 12 7 3\n. 3 1 2 3 11 8 2\n# 4 3 4 9 8 2\n# 4 4 4 8 1 5 2 2\n# 2 6 4 7 2 6 3\n# 2 7 3 6 3 7 2\n# 2 8 3 3 5 7 2\n# 1 9 11 5 4\n# 4 6 11 3 4 2\n. 1 25 4\n. 5 6 8 6 5\n0\n")) {
			int lineCount;
			boolean needsNewLine = false;
			while ((lineCount = Integer.parseInt(in.nextLine())) > 0) {
				if (needsNewLine) {
					System.out.println();
				} else {
					needsNewLine = true;
				}
				
				boolean isOk = true;
				int sum = -1;
				for (int i = 0; i < lineCount; i++) {
					final String line = in.nextLine();
					final int[] counts = getCounts(line.substring(2));
					if (sum < 0) {
						sum = sum(counts);
					} else {
						isOk &= (sum == sum(counts));
					}
					
					char inUse = line.charAt(0);
					for (final int count : counts) {
						for (int k = 0; k < count; k++) {
							System.out.print(inUse);
						}

						inUse = (inUse == '.') ? '#' : '.';
					}
					
					System.out.print('\n');
				}

				if (!isOk) {
					System.out.println("Error decoding image");
				}
			}
		}
	}

	private static int sum(final int[] numbers) {
		int total = 0;
		for (final int number : numbers) {
			total += number;
		}
		
		return total;
	}

	private static int[] getCounts(final String text) {
		final String[] line = text.split(" ");
		final int[] result = new int[line.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(line[i]);
		}
		
		return result;
	}
}
