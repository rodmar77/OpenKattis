import java.util.Scanner;

public class Peg {

    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            final char[][] lines = new char[7][];
            for (int i = 0; i < 7; i++) {
                lines[i] = in.nextLine().toCharArray();
            }

            int count = 0;
            for (int y = 0; y < lines.length; y++) {
                for (int x = 0; x < lines[y].length; x++) {
                    if (canJump(x, y, x-2, y, lines)) count++;
                    if (canJump(x, y, x+2, y, lines)) count++;
                    if (canJump(x, y, x, y-2, lines)) count++;
                    if (canJump(x, y, x, y+2, lines)) count++;
                }
            }

            System.out.println(count);
        }
    }

    private static boolean canJump(final int x0, final int y0, final int x1, final int y1, final char[][] lines) {
        if ((lines[y0][x0] == 'o') && (x1 >= 0) && (x1 <= 6) && (y1 >= 0) && (y1 <= 6) && (lines[y1][x1] == '.')) {
            return (x1 != x0) ? lines[y0][(x0 + x1)/2] == 'o' : lines[(y0 + y1)/2][x0] == 'o';
        }

        return false;
    }
}