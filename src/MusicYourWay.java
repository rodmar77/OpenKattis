import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MusicYourWay {
	public static void main(final String[] args) throws Exception {
		try (final Scanner in = new Scanner(System.in)) {
			final String[] attributes = in.nextLine().split(" ");

			final String[][] records = new String[Integer.parseInt(in.nextLine())][];
			for (int i = 0; i < records.length; i++) {
				records[i] = in.nextLine().split(" ");
			}
			
			final int testCases = in.nextInt();
			for (int i = 0; i < testCases; i++) {
				doSort(records, attributes, in.next());
				doPrint(records, attributes);
				if (i < testCases - 1) {
					System.out.println();
				}
			}
		}
	}

	private static void doPrint(final String[][] records, final String[] attributes) {
		for (int i = 0; i < attributes.length; i++) {
			if (i > 0) {
				System.out.print(" ");
			}
			
			System.out.print(attributes[i]);
		}
		
		System.out.println();
		for (final String[] record : records) {
			for (int i = 0; i < record.length; i++) {
				if (i > 0) {
					System.out.print(" ");
				}
				
				System.out.print(record[i]);
			}

			System.out.println();
		}
	}

	private static void doSort(final String[][] records, final String[] attributes, final String attribute) {
		final int index = getAttributeIndex(attributes, attribute);
		Arrays.sort(records, new Comparator<String[]>() {
			public int compare(final String[] left, final String[] right) {
				final String valueLeft = left[index], valueRight = right[index];
				if (valueLeft.equals(valueRight)) {
					return 0;
				} else {
					return valueLeft.compareTo(valueRight);
				}
			}
		});
	}

	private static int getAttributeIndex(final String[] attributes, final String attribute) {
		for (int index = 0; index < attributes.length; index++) {
			if (attributes[index].equals(attribute)) {
				return index;
			}
		}
		
		return -1;
	}
}
