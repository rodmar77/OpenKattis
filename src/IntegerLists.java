import java.util.Scanner;

public class IntegerLists {

    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            final int testCases = in.nextInt();
            for (int i = 0; i < testCases; i++) {
                System.out.println(getNextResult(in));
            }
        }
    }

    private static String getNextResult(final Scanner in) {
        final String command = in.next();
        final int count = in.nextInt();
        final String[] numbers = in.next().split(",");
        return getNextResult(command, 0, false, 0, count, fix(numbers));
    }

    private static String[] fix(final String[] numbers) {
        numbers[0] = numbers[0].replace("[", "");
        numbers[numbers.length - 1] = numbers[numbers.length - 1].replace("]", "");
        return numbers;
    }

    private static String getNextResult(
                                final String command,
                                final int index,
                                final boolean reversed,
                                final int head,
                                final int tail,
                                final String[] numbers) {

        if (head > tail) {
            return "error";
        } else if (index == command.length()) {
            final StringBuilder result = new StringBuilder("[");
            if (head != tail) {
                if (reversed) {
                    result.append(numbers[tail - 1]);
                    for (int i = tail - 2; i >= head; i--) {
                        result.append(",").append(numbers[i]);
                    }
                } else {
                    result.append(numbers[head]);
                    for (int i = head + 1; i < tail; i++) {
                        result.append(",").append(numbers[i]);
                    }
                }
            }

            return result.append("]").toString();
        } else {
            final char c = command.charAt(index);
            if (c == 'R') {
                final int nextIndex = nextIndexOf(command, 'D', index);
                final boolean invertReversed = ((nextIndex - index) % 2) == 1;
                return getNextResult(
                                command,
                                nextIndex,
                                invertReversed != reversed,
                                head,
                                tail,
                                numbers);
            } else {
                final int nextIndex = nextIndexOf(command, 'R', index);
                final int count = nextIndex - index;
                return getNextResult(
                                command,
                                nextIndex,
                                reversed,
                                (reversed) ? head : head + count,
                                (reversed) ? tail - count : tail,
                                numbers);
            }
        }
    }

    private static int nextIndexOf(final String command, final char c, final int index) {
        final int nextIndex = command.indexOf(c, index);
        return (nextIndex < 0) ? command.length() : nextIndex;
    }
}