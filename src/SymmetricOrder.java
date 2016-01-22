import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SymmetricOrder {
    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            int cases, set = 1;
            while ((cases = in.nextInt()) > 0) {
                final List<String> values = new ArrayList<>();
                for (int i = 0; i < cases; i++) {
                    values.add(in.next());
                }

                for (int i = 1; i <= cases / 2; i++) {
                    values.add(values.size() - i, values.remove(i));
                }

                System.out.println("SET " + (set++));
                values.forEach(System.out::println);
            }
        }
    }
}