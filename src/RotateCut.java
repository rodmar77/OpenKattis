import java.util.Arrays;
import java.util.Scanner;

public class RotateCut {
    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            final int cases = in.nextInt();
            for (int i = 0; i < cases; i++) {
                System.out.println(rotateAndCut(in.nextInt(), in.next()));
            }
        }
    }

    private static String rotateAndCut(final int count, final String text) {
        return rotateAndCut(count, true, 0, 0, text);
    }

    private static String rotateAndCut(
                                final int remaining,
                                final boolean rotated,
                                final int head,
                                final int tail,
                                final String text) {

        if (remaining == 0) {
            return text.substring(head, text.length() - tail);
        } else {
            final int length = (text.length() - head - tail)  / 4;
            if (length > 0) {
                return rotateAndCut(
                                remaining - 1,
                                !rotated,
                                (rotated) ? head + length : head,
                                (rotated) ? tail : tail + length,
                                text
                );
            } else {
                return rotateAndCut(0, ((remaining % 2) == 0) == rotated, head, tail, text);
            }
        }
    }
}
