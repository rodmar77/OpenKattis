import java.util.Scanner;

public class SpeedLimit {
    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            int lines;
            while ((lines = in.nextInt()) > 0) {
                System.out.println(getTotalMiles(in, lines) + " miles");
            }
        }
    }

    public static int getTotalMiles(final Scanner in, final int logCount) {
        int total = 0, prevtime = 0, time;
        for (int i = 0; i < logCount; i++) {
            final int speed = in.nextInt();
            time = in.nextInt();
            total += speed * (time - prevtime);
            prevtime = time;
        }

        return total;
    }
}