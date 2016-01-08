import java.util.*;

public class Easiest {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            int number;
            while ((number = in.nextInt()) > 0) {
                final int sum = sumOfDigits(number);
                int m = 11;
                while (sumOfDigits(number * m) != sum) {
                    m++;
                }

                System.out.println(m);
            }
        }
    }

    private static int sumOfDigits(int number) {
        int total = 0;
        while (number > 0) {
            total += number % 10;
            number /= 10;
        }

        return total;
    }
}