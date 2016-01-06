import java.util.Scanner;

public class EnlargingHashtables {
    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            int number;
            while ((number = in.nextInt()) > 0) {
                int candidate = 2*number + 1;
                while (!isPrime(candidate)) {
                    candidate++;
                }

                System.out.print(candidate);
                if (isPrime(number)) {
                    System.out.println();
                } else {
                    System.out.println(" (" + number + " is not prime)");
                }
            }
        }
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
