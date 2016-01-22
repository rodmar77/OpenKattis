import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Goldbach2 {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int cases = in.nextInt();
            for (int i = 0; i < cases; i++) {
                if (i > 0) System.out.println();
                final int number = in.nextInt();
                final List<String> representations = new ArrayList<>();
                for (int prime = 2; prime <= number/2; prime = getNextPrime(prime)) {
                    final int otherNumber = number - prime;
                    if (isPrime(otherNumber)) {
                        representations.add(prime + "+" + otherNumber);
                    }
                }

                System.out.println(number + " has " + representations.size() + " representation(s)");
                representations.forEach(System.out::println);
            }
        }
    }

    private static int getNextPrime(final int number) {
        int candidate = number;
        do {
            candidate++;
        } while (!isPrime(candidate));

        return candidate;
    }

    public static boolean isPrime(final int number) {
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        } else if ((number % 2) == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                if ((number % i) == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
