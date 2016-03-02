import java.util.Scanner;

public class EncodedMessage {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int count = in.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println(decode(in.next()));
            }
        }
    }

    private static String decode(final String message) {
        final char[] encoded = message.toCharArray();
        final char[] decoded = new char[encoded.length];

        final int sqr = (int) Math.sqrt(encoded.length);
        for (int i = 0, x = 0, y = sqr - 1; i < encoded.length; i++) {
            final int index = y * sqr + x;
            decoded[decoded.length - 1 - i] = encoded[index];

            y--;
            if (y < 0) {
                y = sqr - 1;
                x++;
            }
        }

        return new String(decoded);
    }
}
