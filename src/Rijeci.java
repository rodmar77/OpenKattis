import java.math.BigInteger;
import java.util.*;

public class Rijeci {
    private static Map<Integer, BigInteger> CACHE_A = new HashMap<>();
    private static Map<Integer, BigInteger> CACHE_B = new HashMap<>();

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int count = in.nextInt();
            System.out.println(fibA(count) + " " + fibB(count));
        }
    }

    private static BigInteger fibA(final int count) {
        if (count == 0) {
            return BigInteger.ONE;
        } else if (count == 1) {
            return BigInteger.ZERO;
        } else if (CACHE_A.containsKey(count)) {
            return CACHE_A.get(count);
        } else {
            final BigInteger result = fibA(count - 1).add(fibA(count - 2));
            CACHE_A.put(count, result);
            return result;
        }
    }

    private static BigInteger fibB(final int count) {
        if (count == 0) {
            return BigInteger.ZERO;
        } else if (count == 1) {
            return BigInteger.ONE;
        } else if (CACHE_B.containsKey(count)) {
            return CACHE_B.get(count);
        } else {
            final BigInteger result = fibB(count - 1).add(fibB(count - 2));
            CACHE_B.put(count, result);
            return result;
        }
    }
}