import java.util.Scanner;

public class Maptiles2 {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final String n = in.next();

            final int zoomLevel = n.length();
            int maxx = (int) Math.pow(2, zoomLevel) - 1, maxy = maxx;
            int minx = 0, miny = 0;

            for (int i = 0; i < n.length(); i++) {
                final int digit = Character.digit(n.charAt(i), 10);
                switch (digit) {
                    case 0:  maxx = (maxx + minx + 1) / 2; maxy = (maxy + miny + 1) / 2; break;
                    case 1:  minx = (maxx + minx + 1) / 2; maxy = (maxy + miny + 1) / 2; break;
                    case 2:  maxx = (maxx + minx + 1) / 2; miny = (maxy + miny + 1) / 2; break;
                    default: minx = (maxx + minx + 1) / 2; miny = (maxy + miny + 1) / 2; break;
                }
            }

            System.out.println(zoomLevel + " " + minx + " " + miny);
        }
    }
}
