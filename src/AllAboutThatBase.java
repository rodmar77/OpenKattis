import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllAboutThatBase {

    private static final Pattern OPERATION = Pattern.compile("(.+) ([-+*/]) (.+) = (.+)");

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int cases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cases; i++) {
                System.out.println(getValidBases(in.nextLine()));
            }
        }
    }

    private static String getValidBases(final String line) {
        final Matcher matcher = OPERATION.matcher(line);
        if (matcher.find()) {
            final String left = matcher.group(1);
            final char op = matcher.group(2).charAt(0);
            final String right = matcher.group(3);
            final String result = matcher.group(4);

            final int highest = getHighestDigit(left, right, result);
            final StringBuilder bases = new StringBuilder();

            if ((highest == 1) && (isValid(left, right, op, result, 1))) {
                bases.append(1);
            }

            for (int base = highest + 1; base <= 36; base++) {
                if (isValid(left, right, op, result, base)) {
                    if (base < 10) {
                        bases.append(base);
                    } else if (base == 36) {
                        bases.append(0);
                    } else {
                        bases.append((char) ('a' + (base - 10)));
                    }
                }
            }

            return (bases.length() == 0) ? "invalid" : bases.toString();
        } else {
            return "invalid";
        }
    }

    private static boolean isValid(final String left, final String right, final char op, final String result, final int base) {
        try {
            final BigInteger a = convert(left, base), b = convert(right, base), c = convert(result, base);
            switch (op) {
                case '-': return (a.subtract(b).equals(c));
                case '+': return (a.add(b).equals(c));
                case '*': return (a.multiply(b).equals(c));
                 default: return ((a.mod(b).equals(BigInteger.ZERO)) && (a.divide(b).equals(c)));
            }
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    private static BigInteger convert(final String number, final int base) {
        if (base == 1) {
            if (number.contains("0")) {
                throw new NumberFormatException();
            }

            return BigInteger.valueOf(number.length());
        }

        return new BigInteger(number, base);
    }

    private static int getHighestDigit(final String... numbers) {
        int highest = 0;
        for (final String number : numbers) {
            for (final char c : number.toCharArray()) {
                if (Character.isDigit(c)) {
                    highest = Math.max(highest, Character.digit(c, 10));
                } else {
                    highest = Math.max(highest, 10 + (c - 'a'));
                }
            }
        }

        return highest;
    }
}
