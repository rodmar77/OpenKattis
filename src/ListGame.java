import java.util.Scanner;

public class ListGame {

    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            int number = in.nextInt(), count = 0, prime = 2;
            while (number > 1) {
                if (isPrime(number)) {
                    number = 1;
                    count++;
                } else {
                    while ((number % prime) == 0) {
                        number /= prime;
                        count++;
                    }

                    prime = getNextPrime(prime);
                }
            }

            System.out.println(count);
        }
    }

    private static int getNextPrime(final int prime) {
        int candidate = prime + 1;
        while (!isPrime(candidate)) {
            candidate++;
        }

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
