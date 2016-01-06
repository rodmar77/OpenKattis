import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GolombRulers {
    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                System.out.println(getStatusForRuler(in.nextLine()));
            }
        }
    }

    private static String getStatusForRuler(final String line) {
        final List<Integer> ints = new ArrayList<>();
        try (final Scanner in = new Scanner(line)) {
            while (in.hasNextInt()) {
                ints.add(in.nextInt());
            }
        }

        Collections.sort(ints);
        final Set<Integer> expected = getExpected(ints.get(ints.size() - 1));
        final Set<Integer> contained = new HashSet<>();
        for (int i = 0; i < ints.size() - 1; i++) {
            for (int j = i + 1; j < ints.size(); j++) {
                final int number = ints.get(j) - ints.get(i);
                if (!contained.add(number)) {
                    return "not a ruler";
                }
            }
        }

        expected.removeAll(contained);
        if (expected.isEmpty()) {
            return "perfect";
        } else {
            final StringBuilder result = new StringBuilder("missing ");
            for (final int number : expected) {
                result.append(number).append(' ');
            }

            return result.toString();
        }
    }

    private static Set<Integer> getExpected(final int max) {
        final Set<Integer> result = new TreeSet<>();
        for (int i = 1; i <= max; i++) {
            result.add(i);
        }

        return result;
    }
}
