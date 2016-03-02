import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recenice {

    static class Data {
        private final String text;

        private final int number;
        private final int length;

        Data(final int number) {
            this.number = number;
            this.text = valueOf(number);
            this.length = this.text.length();
        }

        boolean applies(final int phraseLength) {
            return (phraseLength + this.length == this.number);
        }

        String apply(final String phrase) {
            return phrase.replace("$", this.text);
        }
    }

    public static void main(final String[] args) {
        final List<Data> data = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            data.add(new Data(i));
        }

        try (final Scanner in = new Scanner(System.in)) {
            final int n = in.nextInt();
            final StringBuilder phrase = new StringBuilder();
            int phraseLength = -1;
            for (int i = 0; i < n; i++) {
                final String line = in.next();
                phraseLength += line.length();
                if (i > 0) {
                    phrase.append(' ');
                }

                phrase.append(line);
            }

            for (final Data item : data) {
                if (item.applies(phraseLength)) {
                    System.out.println(item.apply(phrase.toString()));
                    break;
                }
            }
        }
    }

    private static String valueOf(final int number) {
        if (number < 10) {
            switch (number) {
                case 0: return "";
                case 1: return "one";
                case 2: return "two";
                case 3: return "three";
                case 4: return "four";
                case 5: return "five";
                case 6: return "six";
                case 7: return "seven";
                case 8: return "eight";
                default: return "nine";
            }
        } else if (number < 20) {
            switch (number) {
                case 10: return "ten";
                case 11: return "eleven";
                case 12: return "twelve";
                case 13: return "thirteen";
                case 14: return "fourteen";
                case 15: return "fifteen";
                case 16: return "sixteen";
                case 17: return "seventeen";
                case 18: return "eighteen";
                default: return "nineteen";
            }
        } else if (number < 100){
            final int n = number / 10;
            switch (n) {
                case 2: return "twenty" + valueOf(number % 10);
                case 3: return "thirty" + valueOf(number % 10);
                case 4: return "forty" + valueOf(number % 10);
                case 5: return "fifty" + valueOf(number % 10);
                case 6: return "sixty" + valueOf(number % 10);
                case 7: return "seventy" + valueOf(number % 10);
                case 8: return "eighty" + valueOf(number % 10);
                default: return "ninety" + valueOf(number % 10);
            }
        } else {
            final int n = number / 100;
            switch (n) {
                case 1: return "onehundred" + valueOf(number % 100);
                case 2: return "twohundred" + valueOf(number % 100);
                case 3: return "threehundred" + valueOf(number % 100);
                case 4: return "fourhundred" + valueOf(number % 100);
                case 5: return "fivehundred" + valueOf(number % 100);
                case 6: return "sixhundred" + valueOf(number % 100);
                case 7: return "sevenhundred" + valueOf(number % 100);
                case 8: return "eighthundred" + valueOf(number % 100);
                default: return "ninehundred" + valueOf(number % 100);
            }
        }
    }
}
