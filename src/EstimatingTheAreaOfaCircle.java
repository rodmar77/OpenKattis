import static java.lang.Math.PI;

import java.math.BigDecimal;
import java.util.Scanner;

public class EstimatingTheAreaOfaCircle {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                final double r = in.nextDouble(), m = in.nextDouble(), c = in.nextDouble();
                if ((r == 0) && (m == 0) && (c == 0)) {
                    break;
                }

                final String trueArea = new BigDecimal(PI * r * r)
                                                    .setScale(9, BigDecimal.ROUND_UP)
                                                    .toString();

                final String measured = new BigDecimal((c / m) * (4*r*r))
                                                    .setScale(9, BigDecimal.ROUND_UP)
                                                    .toString();

                System.out.println(trueArea + " " + measured);
            }
        }
    }
}
