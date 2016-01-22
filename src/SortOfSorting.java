import java.util.*;

public class SortOfSorting {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            int count, index = 0;
            while ((count = in.nextInt()) > 0) {
                if (index++ > 0) System.out.println();
                final List<Comparable[]> objects = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    objects.add(new Comparable[] { in.next(), i });
                }

                Collections.sort(objects, (left, right) -> {
                    final String first = firstTwoChars((String) left[0]);
                    final String second = firstTwoChars((String) right[0]);
                    if (first.equals(second)) {
                        return left[1].compareTo(right[1]);
                    } else {
                        return first.compareTo(second);
                    }
                });

                for (final Comparable[] object : objects) {
                    System.out.println(object[0]);
                }
            }
        }
    }

    private static String firstTwoChars(final String text) {
        return text.substring(0, Math.min(text.length(), 2));
    }
}

