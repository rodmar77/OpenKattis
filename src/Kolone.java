import java.util.Scanner;

public class Kolone {

    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            in.nextLine();
            final char[][] left = zip('0', reverse(in.nextLine().toCharArray()));
            final char[][] right = zip('1', in.nextLine().toCharArray());
            final int seconds = Integer.parseInt(in.nextLine());

            final char[][] result = new char[left.length + right.length][];
            System.arraycopy(left, 0, result, 0, left.length);
            System.arraycopy(right, 0, result, left.length, right.length);
            for (int i = 0; i < seconds; i++) {
                for (int j = 0; j < result.length - 1; ) {
                    if (result[j][0] < result[j + 1][0]) {
                        final char[] tmp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = tmp;
                        j += 2;
                    } else {
                        j++;
                    }
                }
            }

            System.out.println(new String(unzip(result)));
        }
    }

    private static char[] unzip(final char[][] array) {
        final char[] result = new char[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i][1];
        }

        return result;
    }

    private static char[][] zip(final char zip, final char[] array) {
        final char[][] result = new char[array.length][2];
        for (int i = 0; i < array.length; i++) {
            result[i] = new char[] { zip, array[i] };
        }

        return result;
    }

    private static char[] reverse(final char[] chars) {
        final int length = chars.length;
        for (int i = 0; i < length/2; i++) {
            chars[i] += chars[length - i - 1];
            chars[length - i - 1] = (char) (chars[i] - chars[length - i - 1]);
            chars[i] -= chars[length - i - 1];
        }

        return chars;
    }
}
