import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

import java.util.Scanner;

public class SecretMessage {
    public static void main (String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int cases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cases; i++) {
                System.out.println(encode(in.nextLine()));
            }
        }
    }

    private static String encode(final String line) {
        final int ll = (int) ceil(sqrt(line.length()));
        final char[][] text = new char[ll][ll];
        for (int i = 0, index = 0; i < text.length; i++) {
            for (int j = 0; j < text[i].length; j++, index++) {
                text[i][j] = (index >= line.length()) ? '*' : line.charAt(index);
            }
        }

        final StringBuilder result = new StringBuilder();
        for (int j = 0; j < text.length; j++) {
            for (int i = text.length - 1; i >= 0; i--) {
                if (text[i][j] != '*') {
                    result.append(text[i][j]);
                }
            }
        }

        return result.toString();
    }
}