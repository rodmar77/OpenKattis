import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ChartingProgress {

    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            final Collection<String> lines = new ArrayList<>();
            while (in.hasNextLine()) {
                final String line = in.nextLine();
                if (line.isEmpty()) {
                    printSortedLogs(lines);
                    System.out.println();
                    lines.clear();
                } else {
                    lines.add(line);
                }
            }

            printSortedLogs(lines);
        }
    }

    private static void printSortedLogs(final Collection<String> lines) {
        final Collection<String> logLines = sortLogs(lines);
        logLines.forEach(System.out::println);
    }

    private static Collection<String> sortLogs(final Collection<String> lines) {
        int count = 0;
        final Collection<String> result = new ArrayList<>();
        for (final String line : lines) {
            final int asteriskCount = getCount(line, '*');
            result.add(createLine(line.length() - count - asteriskCount, asteriskCount, count));
            count += asteriskCount;
        }

        return result;
    }

    private static String createLine(
                                final int prefixLength,
                                final int asteriskCount,
                                final int suffixLength) {

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < prefixLength; i++) result.append('.');
        for (int i = 0; i < asteriskCount; i++) result.append('*');
        for (int i = 0; i < suffixLength; i++) result.append('.');
        return result.toString();
    }

    private static int getCount(final String line, final char c) {
        return (int) line.chars().filter(n -> n == c).count();
    }
}
