import java.util.Scanner;

import static java.lang.Math.toRadians;
import static java.lang.Math.sin;

public class SantaKlas {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner("10000 359")) {
            final int height = in.nextInt();
            final double degree = in.nextDouble();
            if (degree <= 180) {
                System.out.println("safe");
            } else {
                final double radians = toRadians((degree <= 270) ? 270 - degree : 360 - degree);
                System.out.println((radians > 0) ? (int) (height / sin(radians)) : height);
            }
        }
    }
}
