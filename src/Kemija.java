import java.util.*;

public class Kemija {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final String line = in.nextLine();
            System.out.println(line.replaceAll("([aeiou])p\\1", "$1"));
        }
    }
}