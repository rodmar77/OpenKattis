import java.util.Scanner;

public class FunHouse {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            int w, h, currX = -1, currY = -1, index = 1;
            while (((w = in.nextInt()) > 0) && ((h = in.nextInt()) > 0)) {
                in.nextLine();

                final char[][] chars = new char[h][w];
                for (int y = 0; y < h; y++) {
                    chars[y] = in.nextLine().toCharArray();
                    for (int x = 0; x < chars[y].length; x++) {
                        if (chars[y][x] == '*') {
                            currX = x;
                            currY = y;
                        }
                    }
                }

                // 1 = ->, 2 = <-, 3 = ^, 4 = v
                int direction;
                if (currY == 0)          direction = 4;
                else if (currY == h - 1) direction = 3;
                else if (currX == w - 1) direction = 2;
                else direction = 1;

                do {
                    if (direction == 1)      currX++;
                    else if (direction == 2) currX--;
                    else if (direction == 3) currY--;
                    else currY++;

                    if (currX == w) {
                        currX--;
                        break;
                    } else if (currY == h) {
                        currY--;
                        break;
                    } else if (chars[currY][currX] == '/') {
                        if (direction == 1)      direction = 3;
                        else if (direction == 2) direction = 4;
                        else if (direction == 3) direction = 1;
                        else direction = 2;
                    } else if (chars[currY][currX] == '\\') {
                        if (direction == 1)      direction = 4;
                        else if (direction == 2) direction = 3;
                        else if (direction == 3) direction = 2;
                        else direction = 1;
                    }
                } while ((currX > 0) && (currY > 0));

                chars[currY][currX] = '&';
                System.out.println("HOUSE " + (index++));
                for (final char[] line : chars) {
                    System.out.println(new String(line));
                }
            }
        }
    }
}
