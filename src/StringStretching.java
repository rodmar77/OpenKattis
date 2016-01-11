import java.util.Scanner;

public class StringStretching {

    public static void main (String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final char[] chars = in.next().toCharArray();
            for (int position = 1; position <= chars.length; position++) {
                if (chars.length % position == 0) {
                    String best = null;
                    for (int offset = 0; offset + position <= chars.length; offset++) {
                        if (generatable(chars, position, offset)) {
                            final String candidate = new String(chars, offset, position);
                            if ((best == null) || (candidate.compareTo(best) < 0)) {
                                best = candidate;
                            }
                        }
                    }

                    if (best != null) {
                        System.out.println(best);
                        break;
                    }
                }
            }
        }
    }

    private static boolean generatable(final char[] chars, final int position, final int offset) {
        final int length = chars.length;
        final boolean[][][] seen = new boolean[length][length / position + 1][position + 1];
        final boolean[][][] dp = new boolean[length][length / position + 1][position + 1];
        return (generatable(chars, seen, dp, 0, position, offset, length / position, 0));
    }

    private static boolean generatable(
                                final char[] chars,
                                final boolean[][][] seen,
                                final boolean[][][] dp,
                                final int s,
                                final int position,
                                final int off,
                                final int copies,
                                final int curletter) {

        if (copies == 0) {
            return true;
        } else if (curletter == position) {
            return generatable(chars, seen, dp, s, position, off, copies - 1, 0);
        } else if (seen[s][copies][curletter]) {
            return dp[s][copies][curletter];
        }

        seen[s][copies][curletter] = true;
        boolean ok = (chars[curletter + off] == chars[s]) && (generatable(chars, seen, dp, s+1, position, off, copies, curletter+1));
        for (int times = 1; !ok && times < copies; times++) {
            ok |= (generatable(chars, seen, dp, s, position, off, times, 0))
                    && (generatable(chars, seen, dp, s + times * position, position, off, copies - times, curletter));
        }

        return dp[s][copies][curletter] = ok;
    }
}