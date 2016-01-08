import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeBomb {

    private static final String[] DIGITS = {
            "**** ** ** ****",
            "  *  *  *  *  *",
            "***  *****  ***",
            "***  ****  ****",
            "* ** ****  *  *",
            "****  ***  ****",
            "****  **** ****",
            "***  *  *  *  *",
            "**** ***** ****",
            "**** ****  ****"};

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final List<String> digits = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                final String line = in.nextLine();
                for (int j = 0; j < ((line.length() + 1) / 4); j++) {
                    final String value = line.substring(j*4, j*4 + 3);
                    if (i == 0) {
                        digits.add(value);
                    } else {
                        digits.set(j, digits.get(j) + value);
                    }
                }
            }

            final int number = getActualNumber(digits);
            System.out.println(((number > 0) && ((number % 6) == 0)) ? "BEER!!" : "BOOM!!");
        }
    }

    private static int getActualNumber(final List<String> digits) {
        int mult = (int) Math.pow(10, digits.size() - 1), result = 0;
        for (final String digit : digits) {
            final int actualDigit = getActualDigit(digit);
            if (actualDigit < 0) {
                return -1;
            }

            result += (mult * actualDigit);
            mult /= 10;
        }

        return result;
    }

    private static int getActualDigit(final String digit) {
        for (int i = 0; i < DIGITS.length; i++) {
            if (digit.equals(DIGITS[i])) {
                return i;
            }
        }

        return -1;
    }
}
