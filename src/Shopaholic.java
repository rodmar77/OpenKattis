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
            for (int i = ns.length - 3; i >= 0; i -= 3) {
                result += ns[i];
            }

            System.out.println(result);
        }
    }
}