import java.util.*;

public class TextureAnalysis {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            String line;
            int index = 1;
            while (!(line = in.nextLine()).equals("END")) {
                int length = -1, prevIdx = line.indexOf('*'), idx;
                boolean matches = true;

                while ((matches) && ((idx = line.indexOf('*', prevIdx + 1)) > 0)) {
                    if (length == -1) {
                        length = idx - prevIdx - 1;
                    } else {
                        matches = ((idx - prevIdx - 1) == length);
                    }

                    prevIdx = idx;
                }

                System.out.println((index++) + " " + ((matches) ? "EVEN" : "NOT EVEN"));
            }
        }
    }
}