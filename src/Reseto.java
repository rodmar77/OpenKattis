import java.util.Scanner;

public class Reseto {

    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            final boolean[] ns = new boolean[in.nextInt() + 1];
            int k = in.nextInt(), index = 0, mult = 1;
            while (k > 0) {
                mult++;
                for (int i = mult; (k > 0) && (i < ns.length); i += mult) {
                    if (!ns[i]) {
                        ns[(index = i)] = true;
                        k--;
                    }
                }
            }

            System.out.println(index);
        }
    }
}
