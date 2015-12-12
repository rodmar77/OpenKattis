import java.util.Scanner;

public class ParsingHex {

	public static void main(final String[] args) {
		try (final Scanner in = new Scanner(System.in)) {
			final String allowed = "0123456789abcdef";
			while (in.hasNext()) {
				final String next = in.nextLine(), lowered = next.toLowerCase();
				int index = -1;
				while ((index = lowered.indexOf("0x", index + 1)) >= 0) {
					final StringBuilder sb = new StringBuilder(next.substring(index, index + 2));
					for (int nextIndex = index + 2; ((nextIndex < next.length()) && (allowed.indexOf(lowered.charAt(nextIndex)) >= 0)); nextIndex++) {
						sb.append(next.charAt(nextIndex));
					}
					
					final String number = sb.toString();
					if (number.length() > 2) {
						System.out.println(number + " " + Long.valueOf(number.substring(2), 16));
					}
				}
			}
		}
	}
	
}
