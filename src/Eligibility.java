import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Eligibility {

    private static final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int cases = in.nextInt();
            for (int i = 0; i < cases; i++) {
                System.out.println(isEligible(in.next(), getYear(in.next()), getYear(in.next()), in.nextInt()));
            }
        }
    }

    private static int getYear(final String text) {
        return Integer.parseInt(text.substring(0, 4));
    }

    private static String isEligible(final String name, final int startYear, final int birthYear, final int courses) {
        if ((startYear >= 2010) || (birthYear >= 1991)) {
            return name + " eligible";
        } else if ((courses / 5d) > 8) {
            return name + " ineligible";
        } else {
            return name + " coach petitions";
        }
    }
}
