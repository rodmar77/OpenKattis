import java.util.*;

public class ReverseRot {
    private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.".toCharArray();

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            int rot;
            while ((rot = in.nextInt()) > 0) {
                final char[] reverse = new StringBuilder(in.next()).reverse().toString().toCharArray();
                final char[] result = new char[reverse.length];
                for (int i = 0; i < reverse.length; i++) {
                    int index = -1;
                    for (int j = 0; (index < 0) && (j < CHARS.length); j++) {
                        if (CHARS[j] == reverse[i]) {
                            index = j;
                        }
                    }

                    result[i] = CHARS[(index + rot) % CHARS.length];
                }

                System.out.println(new String(result));
            }
        }
    }
}