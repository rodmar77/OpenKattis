import static java.lang.Math.ceil;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.util.Scanner;

public class Ladder {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final double h = in.nextInt(), degree = in.nextDouble();
            System.out.println((int) ceil(h / sin(toRadians(degree))));
        }
    }
}
