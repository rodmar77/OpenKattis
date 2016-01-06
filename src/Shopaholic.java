import java.util.Arrays;
import java.util.Scanner;

public class Shopaholic {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int[] ns = new int[in.nextInt()];
            for (int i = 0; i < ns.length; i++) {
                ns[i] = in.nextInt();
            }

            Arrays.sort(ns);
            long result = 0;
            for (int items = 3; items <= ns.length; items++) {
                result = Math.max(result, getTotal(ns, items));
            }

            System.out.println(result);
        }
    }

    private static long getTotal(final int[] ns, final int items) {
        long total = 0;
        final int itemCount = items / 3;
        for (int n = ns.length - 1; n >= 0; n -= items) {
            for (int i = 0; i < itemCount; i++) {
                if (n >= (items - 1)) {
                    total += ns[n - items + 1 + i];
                }
            }
        }

        return total;
    }
}