import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StringStretching {
	public static void main(final String[] args) throws Exception {
		try (final Scanner in = new Scanner("abababcabcabcabcabcabcabcabcabccbacbacbacbacbacbacbaababcabccbacbacabcabcabccbacabcabcabccbacbacabcabccbacbababccbaabacbacbacbacbacabcabcabcabcabccbacbacbacbacbacbaccbaabababcabcabcabcabcabcabcabcabccbacbacbacbacbacbacbaababcabccbacbacabcabcabccbacabcabcabccbacbacabcabccbacbababccbaabacbacbacbacbacabcabcabcabcabccbacbacbacbacbacbaccba")) {
			final long time = -System.currentTimeMillis();
			final String text = in.nextLine();
			final Set<Character> chars = getDistinctChars(text);
			final char first = text.charAt(0), last = text.charAt(text.length() - 1);

			if (chars.size() == 1) {
				System.out.println("" + first);
			} else {
				String generator = text;

				int start = -1;
				while ((start = text.indexOf(first, start + 1)) >= 0) {
					int end = start;
					while ((end = text.indexOf(last, end + 1)) > 0) {
						final String candidate = text.substring(start, end + 1);
						if (candidate.length() > generator.length()) {
							break;
						} else if ((!candidate.equals(generator)) && (getDistinctChars(candidate).containsAll(chars)) && (isValid(text, candidate))) {
							if (candidate.length() < generator.length()) {
								generator = candidate;
							} else if ((candidate.length() == generator.length()) && (candidate.compareTo(generator) < 0)) {
								generator = candidate;
							}
						}
					}
				}
				
				System.out.println(generator + ", found in " + (time + System.currentTimeMillis()) + "ms.");
			}
		}
	}

	private static boolean isValid(final String text, final String candidate) {
		return isValid(text, candidate, new HashMap<String, Boolean>());
	}
	
	private static boolean isValid(final String text, final String candidate, final Map<String, Boolean> cache) {
		if (text.isEmpty()) {
			return true;
		} else if ((!text.contains(candidate)) || (text.charAt(0) != candidate.charAt(0)) || (text.charAt(text.length() - 1) != candidate.charAt(candidate.length() - 1))) {
			return false;
		} else if (candidate.charAt(0) != candidate.charAt(candidate.length() - 1)) {
			return isValid(text.replace(candidate, ""), candidate, cache);
		} else if (hasInvalidRepetition(text, candidate)) {
			return false;
		} else {
			int index = -1;
			while ((index = text.indexOf(candidate, index + 1)) >= 0) {
				final String nextText = text.substring(0, index) + text.substring(index + candidate.length());
				if (cache.containsKey(nextText)) {
					if (cache.get(nextText)) {
						return true;
					}
				} else {
					final boolean result = isValid(nextText, candidate, cache);
					cache.put(nextText, result);
					if (result) {
						return true;
					}
				}
			}
			
			return false;
		}
	}

	private static boolean hasInvalidRepetition(final String text, final String candidate) {
		for (int i = 1; i < candidate.length() - 1; i++) {
			final char c = candidate.charAt(i);
			if (c != text.charAt(0)) {
				final StringBuilder sb = new StringBuilder().append(c);
				for (int k = 1; k < text.length(); k++) {
					sb.append(c);
					if ((!candidate.contains(sb.toString())) && (text.contains(sb.toString()))) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	private static Set<Character> getDistinctChars(final String text) {
		final Set<Character> result = new HashSet<>();
		for (final char c : text.toCharArray()) {
			result.add(c);
		}

		return result;
	}
}
