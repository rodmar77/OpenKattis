import java.util.Scanner;

public class GrowlingGears {

    // T=−aR2+bR+c
    public static void main(final String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            final int cases = in.nextInt();
            for (int i = 0; i < cases; i++) {
                System.out.println(bestTorque(in));
            }
        }
    }

    private static int bestTorque(final Scanner in) {
        final int gears = in.nextInt();
        int bestId = -1;
        double bestTorque = Double.MIN_VALUE;
        for (int i = 0; i < gears; i++) {
            final double torque = getMaxTorque(in.nextDouble(), in.nextDouble(), in.nextDouble());
            if (torque > bestTorque) {
                bestTorque = torque;
                bestId = i;
            }
        }

        return bestId + 1;
    }

    public static double getMaxTorque(final double a, final double b, final double c) {
        return (-3*b*b/4) + c;
    }
}
