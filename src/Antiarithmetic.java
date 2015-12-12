import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Antiarithmetic {
	public static void main(final String[] args) throws Exception {
		try (final Scanner in = new Scanner(new File("/tmp/bu.txt"))) {
			while (true) {
				final String testCase = in.next();
				if ("0".equals(testCase)) {
					break;
				}

				final int index = testCase.indexOf(':');
				final int[] array = new int[Integer.parseInt(testCase.substring(0, index))];
				for (int i = 0; i < array.length; i++) {
					array[i] = in.nextInt();
				}
				
				final Map<Integer, Integer> values = $(array);
				
				boolean found = false;
				for (int i = 0; (!found) && (i < array.length); i++) {
					final int ai = array[i];
					for (int j = i + 1; (!found) && (j < array.length); j++) {
						final int aj = array[j];

						if (aj > ai) {
							final int first = values.getOrDefault(2*ai - aj, -1);
							found |= ((first >= 0) && (first < i));
							
							final int middle = values.getOrDefault((ai + aj)/2, -1);
							found |= (((ai + aj) % 2 == 0) && (middle > i) && (middle < j));

							final int last = values.getOrDefault(2*aj - ai, -1);
							found |= (last > j);
						} else {
							final int first = values.getOrDefault(2*aj - ai, -1);
							found |= (first > j);
							
							final int middle = values.getOrDefault((ai + aj)/2, -1);
							found |= (((ai + aj) % 2 == 0) && (middle > j) && (middle < i));

							final int last = values.getOrDefault(2*ai - aj, -1);
							found |= ((last >= 0) && (last < i));
						}
					}
				}
				
				System.out.println(found ? "no" : "yes");
			}
		}
	}

	private static Map<Integer, Integer> $(final int... array) {
		final Map<Integer, Integer> result = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			result.put(array[i], i);
		}
		
		return result;
	}
}