import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class RepeatingDecimal {
    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                final BigDecimal dividend = new BigDecimal(in.next());
                final BigDecimal divisor = new BigDecimal(in.next());

                final int scale = in.nextInt();
                System.out.println(dividend.divide(divisor, scale + 1, RoundingMode.DOWN).setScale(scale, RoundingMode.DOWN));
            }
        }
    }
}
