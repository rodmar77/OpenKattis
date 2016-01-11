import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Metaprogramming {

    private static final Map<String, Integer> definitions = new HashMap<>();

    private static final Pattern define = Pattern.compile("define (\\d+) (.+)");
    private static final Pattern eval = Pattern.compile("eval (.+) ([<>=]) (.+)");

    public static void main (String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                execute(in.nextLine());
            }
        }
    }

    private static void execute(final String line) {
        if (line.startsWith("define")) {
            define(line);
        } else {
            eval(line);
        }
    }

    private static void eval(final String line) {
        final Matcher matcher = eval.matcher(line);
        if (matcher.find()) {
            final String left = matcher.group(1), right = matcher.group(3);
            final char op = matcher.group(2).charAt(0);
            System.out.println(eval(left, right, op));
        }
    }

    private static String eval(final String left, final String right, final char op) {
        if ((definitions.containsKey(left)) && (definitions.containsKey(right))) {
            final int a = definitions.get(left), b = definitions.get(right);
            switch (op) {
                case '<': return String.valueOf(a < b);
                case '>': return String.valueOf(a > b);
                default : return String.valueOf(a == b);
            }
        } else {
            return "undefined";
        }
    }

    private static void define(final String line) {
        final Matcher matcher = define.matcher(line);
        if (matcher.find()) {
            definitions.put(matcher.group(2), Integer.valueOf(matcher.group(1)));
        }
    }
}
