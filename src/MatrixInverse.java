import java.util.Scanner;

public class MatrixInverse {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            int index = 1;
            while (in.hasNextInt()) {
                final int a = in.nextInt(),
                          b = in.nextInt(),
                          c = in.nextInt(),
                          d = in.nextInt();

                final int h = a / (a*d - c*b),
                          f = (-b*h)/a,
                          g = c * (b*c - a*d);

                final int e;
                if (c == 0) {
                    e = (1 - b*c*(b*c - a)) / a;
                } else {
                    e = (-d*g)/c;
                }

                System.out.println("Case " + (index++) + ":");
                System.out.println(e + " " + f);
                System.out.println(g + " " + h);
            }
        }
    }
}
