import java.util.Scanner;

public class Kornislav {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int[] original = { in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() };
            System.out.println(maxArea(original));
        }
    }

    private static int maxArea(final int[] original) {
        final int[][] combinations = getCombinations(original);
        int max = 0;
        for (final int[] combination : combinations) {
            final int a = combination[0], b = combination[1], c = combination[2], d = combination[3];
            if ((c <= a) && (d >= b)) {
                final int area = c*b;
                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }

    private static int[][] getCombinations(final int[] original) {
        final int[][] result = new int[24][];
        int index = 0;
        for (int _1 = 0; _1 < 4; _1++) {
            for (int _2 = 0; _2 < 4; _2++) {
                if (_2 != _1) {
                    for (int _3 = 0; _3 < 4; _3++) {
                        if ((_3 != _1) && (_3 != _2)) {
                            for (int _4 = 0; _4 < 4; _4++) {
                                if ((_4 != _3) && (_4 != _2) && (_4 != _1)) {
                                    result[index++] = new int[] { original[_1], original[_2], original[_3], original[_4]};
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
