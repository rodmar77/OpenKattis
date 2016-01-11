import java.util.Arrays;
import java.util.Scanner;

public class SynchronizingLists {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            int length, index = 0;
            while ((length = in.nextInt()) > 0) {
                if (index++ > 0){
                    System.out.println();
                }

                final int[][] numbers = getArray(in, length);
                final int[] toSynch = new int[length];
                for (int i = 0; i < length; i++) {
                    toSynch[i] = in.nextInt();
                }

                Arrays.sort(numbers, (left, right) -> left[1] - right[1]);
                Arrays.sort(toSynch);
                final int[] result = new int[length];
                for (int i = 0; i < length; i++) {
                    result[numbers[i][0]] = toSynch[i];
                }

                for (final int number : result) {
                    System.out.println(number);
                }
            }
        }
    }

    private static int[][] getArray(Scanner in, int length) {
        final int[][] numbers = new int[length][];
        for (int i = 0; i < length; i++) {
            numbers[i] = new int[] { i, in.nextInt() };
        }

        return numbers;
    }
}