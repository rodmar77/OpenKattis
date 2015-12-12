import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AddingWords {

	private static final Map<String, Integer> numbers = new HashMap<>();
	private static final StringBuilder results = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		try (final Scanner in = new Scanner(System.in)) {
			while (in.hasNextLine()) {
				processLine(in.nextLine());
			}
			
			System.out.println(results.toString());
		}
	}

	private static void processLine(final String line) {
		try (final Scanner in = new Scanner(line)) {
			final String command = in.next();
			if (command.equalsIgnoreCase("clear")) {
				numbers.clear();
			} else if (command.equalsIgnoreCase("def")) {
				numbers.put(in.next(), in.nextInt());
			} else {
				int result = 0, op = 0;
				boolean valid = true;

				String token;
				while (!(token = in.next()).equals("=")) {
					if (valid) {
						if ("-".equals(token)) {
							op = -1;
						} else if ("+".equals(token)) {
							op = 1;
						} else if (!numbers.containsKey(token)) {
							valid = false;
						} else if (op == 0) {
							result = numbers.get(token);
						} else if (op == 1) {
							result += numbers.get(token);
						} else {
							result -= numbers.get(token);
						}
					}
					
					results.append(token).append(" ");
				}
				
				results
					.append("= ")
					.append((valid) ? getKeyFor(result) : "unknown")
					.append("\n");
			}
		}
	}

	private static String getKeyFor(final int number) {
		for (final Entry<String, Integer> entry : numbers.entrySet()) {
			if (entry.getValue().intValue() == number) {
				return entry.getKey();
			}
		}
		
		return "unknown";
	}

}
