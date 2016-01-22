import static java.lang.Math.sqrt;
import java.util.Scanner;

class Complex {

    private final double real;
    private final double complex;

    Complex(final double real, final double complex) {
        this.real = real;
        this.complex = complex;
    }

    Complex add(final Complex that) {
        return new Complex(this.real + that.real, this.complex + that.complex);
    }

    Complex squared() {
        return new Complex(real*real - complex*complex, 2*real*complex);
    }

    double module() {
        return sqrt(real*real + complex*complex);
    }
}

public class InOrOut {
    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            int caseNumber = 0;
            while (in.hasNext()) {
                final boolean divergent = diverges(in.nextDouble(), in.nextDouble(), in.nextInt());
                System.out.println("CASE " + (++caseNumber) + ": " + ((divergent) ? "OUT" : "IN"));
            }
        }
    }

    private static boolean diverges(final double real, final double complex, final int interactions) {
        final Complex c = new Complex(real, complex);

        Complex z = c;

        int interaction = 0;
        while ((z.module() <= 2) && (++interaction < interactions)) {
            z = z.squared().add(c);
        }

        return (z.module() > 2);
    }
}