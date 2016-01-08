import java.util.*;

public class PrimePath {
    private static final int INFINITE = 100000000;

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int cases = in.nextInt();
            for (int i = 0; i < cases; i++) {
                System.out.println(getMinimalPath(in.nextInt(), in.nextInt()));
            }
        }
    }

    private static String getMinimalPath(final int from, final int to) {
        final int result = getMinimalPath(from, to, new ArrayList<>(), new HashMap<>());
        return (result >= INFINITE) ? "impossible" : String.valueOf(result);
    }

    private static int getMinimalPath(
                            final int current,
                            final int to,
                            final List<Integer> path,
                            final Map<Integer, Integer> costMap) {

        if (costMap.containsKey(current)) {
            return costMap.get(current);
        } else if (current == to) {
            return 0;
        } else {
            final List<Integer> candidates = getCandidates(current);
            int minimal = INFINITE;
            for (final Integer candidate : candidates) {
                if ((!path.contains(candidate)) && (distance(candidate, to) <= distance(current, to))) {
                    final List<Integer> nextPath = new ArrayList<>(path);
                    nextPath.add(candidate);

                    final int size = 1 + getMinimalPath(candidate, to, nextPath, costMap);
                    if (size < minimal) {
                        minimal = size;
                    }
                }
            }

            costMap.put(current, minimal);
            return minimal;
        }
    }

    private static int distance(int from, int to) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if ((from % 10) != (to % 10)) {
                distance++;
            }

            from /= 10;
            to /= 10;
        }

        return distance;
    }

    private static List<Integer> getCandidates(final int number) {
        final List<Integer> candidates = new ArrayList<>();
        final String value = String.valueOf(number);
        for (int i = 0; i < value.length(); i++) {
            final char[] chars = value.toCharArray();
            for (char c = (i == 0) ? '1' : '0'; c <= '9'; c++) {
                if (c != chars[i]) {
                    chars[i] = c;
                    final int newNumber = Integer.parseInt(new String(chars));
                    if (isPrime(newNumber)) {
                        candidates.add(newNumber);
                    }
                }
            }
        }

        return candidates;
    }

    public static boolean isPrime(final int number) {
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        } else if ((number % 2) == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                if ((number % i) == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}