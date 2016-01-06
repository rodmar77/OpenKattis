import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StringStretching {

    private static class TextData {
        private final String text;
        private final Set<Character> chars;
        private final Map<Character, Integer> largestRepetitions;
        private final Map<Character, Integer> charCount;

        private Map<Character, Integer> getLargestRepetitions(
                                                        final Set<Character> distinctChars,
                                                        final String text) {

            final Map<Character, Integer> result = new HashMap<>();
            distinctChars.forEach(c -> {
                if ((c != text.charAt(0)) && (c != text.charAt(text.length() - 1))) {
                    result.put(c, getLargestRepetition(c, text));
                }
            });

            return result;
        }


        private Map<Character, Integer> getCharsCount(
                                                final Set<Character> chars,
                                                final String text) {

            final Map<Character, Integer> result = new HashMap<>();
            chars.forEach(c -> result.put(c, getCharCount(c, text)));
            return result;
        }

        private TextData(final String text) {
            this.text = text;
            this.chars = getDistinctChars(text);
            this.largestRepetitions = getLargestRepetitions(chars, text);
            this.charCount = getCharsCount(chars, text);
        }

        public boolean hasCorrectCharCount(final String candidate) {
            int divisor = 0;
            for (final Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                final int count = getCharCount(entry.getKey(), candidate);
                if ((entry.getValue() % count) > 0) {
                    return false;
                } else if (divisor > 0) {
                    if ((entry.getValue() / count) != divisor) {
                        return false;
                    }
                } else {
                    divisor = entry.getValue() / count;
                }
            }

            return true;
        }

        public boolean hasValidRepetition(final String candidate) {
            for (final Map.Entry<Character, Integer> entry : largestRepetitions.entrySet()) {
                final int largest = getLargestRepetition(entry.getKey(), candidate);
                if (largest != entry.getValue()) {
                    return false;
                }
            }

            return true;
        }

        public char firstChar() {
            return text.charAt(0);
        }

        public char lastChar() {
            return text.charAt(text.length() - 1);
        }

        public int distinctCharCount() {
            return this.chars.size();
        }

        public String getText() {
            return text;
        }

        public int indexOf(final char c, final int from) {
            return text.indexOf(c, from);
        }

        public String substring(final int from, final int to) {
            return text.substring(from, to);
        }

        public boolean hasAllChars(String candidate) {
            return getDistinctChars(candidate).containsAll(chars);
        }
    }

    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner("babababababacababacaababacaacababcabababababacaacbabacababacaacababacababababcaacababbacbabababacbabacaacababaacababcaacabababbabacaacabababacababacababacaacababacababacababacaacababbabbabcbabacaacababaacabababacaacababbcaacabababacaacababbbabacaacabababacaacabababacaacababbb")) {
            final long time = -System.currentTimeMillis();

            final TextData text = new TextData(in.nextLine());
            final char first = text.firstChar(), last = text.lastChar();
            if (text.distinctCharCount() == 1) {
                System.out.println("" + first);
            } else {
                String generator = text.getText();
                final Set<String> verified = new HashSet<>();

                int start = -1;
                while ((start = text.indexOf(first, start + 1)) >= 0) {
                    int end = start;
                    while ((end = text.indexOf(last, end + 1)) > 0) {
                        final String candidate = text.substring(start, end + 1);
                        if (candidate.length() > generator.length()) {
                            break;
                        } else if (
                                (verified.add(candidate))
                             && (!candidate.equals(generator))
                             && ((candidate.length() < generator.length()) || ((candidate.length() == generator.length()) && (candidate.compareTo(generator) < 0)))
                             && (isValid(text, candidate))) {

                            generator = candidate;
                        }
                    }
                }

                System.out.println(generator + ", found in " + (time + System.currentTimeMillis()) + "ms.");
            }
        }
    }

    private static int getCharCount(final char c, final String text) {
        return (int) text.chars().filter(n -> c == n).count();
    }

    private static boolean isValid(
                                final TextData text,
                                final String candidate) {

        return ((text.hasAllChars(candidate))
            && (text.hasCorrectCharCount(candidate))
            && (text.hasValidRepetition(candidate))
            && (isValid(text.getText(), candidate, new HashMap<>())));
    }

    private static boolean isValid(
                                final String currentText,
                                final String candidate,
                                final Map<String, Boolean> cache) {
        if (currentText.isEmpty()) {
            return true;
        } else if (
              ((currentText.length() % candidate.length()) > 0)
            || (!currentText.contains(candidate))
            || (currentText.charAt(0) != candidate.charAt(0))
            || (currentText.charAt(currentText.length() - 1) != candidate.charAt(candidate.length() - 1))) {

            return false;
        } else if (candidate.charAt(0) != candidate.charAt(candidate.length() - 1)) {
            return isValid(currentText.replace(candidate, ""), candidate, cache);
        } else {
            int index = -1;
            while ((index = currentText.indexOf(candidate, index + 1)) >= 0) {
                final String nextText = currentText.substring(0, index) + currentText.substring(index + candidate.length());
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

    private static int getLargestRepetition(final char c, final String text) {
        int largest = 1, start, end = 0;
        while ((start = text.indexOf(c, end)) > 0) {
            end = start + 1;
            while ((end < text.length()) && (text.charAt(end) == c)) {
                end++;
            }

            largest = Math.max(largest, end - start);
        }

        return largest;
    }

    private static Set<Character> getDistinctChars(final String text) {
        final Set<Character> result = new HashSet<>();
        for (final char c : text.toCharArray()) {
            result.add(c);
        }

        return result;
    }
}