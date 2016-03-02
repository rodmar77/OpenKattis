import java.util.Scanner;

public class Wertyu {
    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
            final String line = in.nextLine();
            for (final char c : line.toCharArray()) {
                System.out.print(convert(c));
            }

            System.out.println();
        }}
    }

    private static char convert(final char in) {
        final String first = "`1234567890-=QWERTYUIOP[]\\\\ASDFGHJKL;'ZXCVBNM,./";
        if (first.indexOf(in) > 0) {
            return first.charAt(first.indexOf(in) - 1);
        }

        return in;
    }
}
