import java.util.Scanner;

public class ImageDecoding {

    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            int lineCount;
            boolean needsNewLine = false;
            while ((lineCount = Integer.parseInt(in.nextLine())) > 0) {
                if (needsNewLine) {
                    System.out.println();
                } else {
                    needsNewLine = true;
                }

                boolean isOk = true;
                int sum = -1;
                for (int i = 0; i < lineCount; i++) {
                    final String line = in.nextLine();
                    final int[] counts = getCounts(line.substring(2));
                    if (sum < 0) {
                        sum = sum(counts);
                    } else {
                        isOk &= (sum == sum(counts));
                    }

                    char inUse = line.charAt(0);
                    for (final int count : counts) {
                        for (int k = 0; k < count; k++) {
                            System.out.print(inUse);
                        }

                        inUse = (inUse == '.') ? '#' : '.';
                    }

                    System.out.print('\n');
                }

                if (!isOk) {
                    System.out.println("Error decoding image");
                }
            }
        }
    }

    private static int sum(final int[] numbers) {
        int total = 0;
        for (final int number : numbers) {
            total += number;
        }

        return total;
    }

    private static int[] getCounts(final String text) {
        final String[] line = text.split(" ");
        final int[] result = new int[line.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(line[i]);
        }

        return result;
    }
}
