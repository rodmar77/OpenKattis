import java.util.*;

public class Acm {
    private static class Data {
        private boolean solved;
        private int time;
        private int guesses;

        Data(final boolean solved, final int time) {
            this.solved = solved;
            this.time = time;
            this.guesses = (solved) ? 0 : 1;
        }

        void increment(final boolean solved, final int time) {
            this.solved = solved;
            this.time = time;
            this.guesses += (solved) ? 0 : 1;
        }

        int getTime() {
            return this.time + (20 * this.guesses);
        }
    }

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final Map<String, Data> problems = new HashMap<>();
            while (true) {
                final int time = in.nextInt();
                if (time < 0) {
                    break;
                }

                final String problem = in.next();
                final boolean solved = "right".equals(in.next());

                if (problems.containsKey(problem)) {
                    problems.get(problem).increment(solved, time);
                } else {
                    problems.put(problem, new Data(solved, time));
                }
            }

            int totalTime = 0, totalSolved = 0;
            for (final Data data : problems.values()) {
                if (data.solved) {
                    totalSolved++;
                    totalTime += data.getTime();
                }
            }

            System.out.println(totalSolved + " " + totalTime);
        }
    }
}