import java.util.*;

public class FunctionalFun {
    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                System.out.println(getFunctionType(in));
            }
        }
    }

    private static String getFunctionType(final Scanner in) {
        getInfo(in.nextLine());
        final Set<String> codomain = getInfo(in.nextLine());

        final Map<String, String> map = new HashMap<>();
        final int count = Integer.parseInt(in.nextLine());

        boolean injective = true, isFunction = true;
        for (int i = 0; i < count; i++) {
            final String[] values = getValues(in.nextLine());
            if (map.containsKey(values[0])) {
                final String value = map.get(values[0]);
                if (!values[1].equals(value)) {
                    isFunction = false;
                }
            } else if (map.containsValue(values[1])) {
                for (final Map.Entry<String, String> entry : map.entrySet()) {
                    if (values[1].equals(entry.getValue())) {
                        injective &= values[0].equals(entry.getKey());
                    }
                }
            } else {
                map.put(values[0], values[1]);
            }
        }

        final boolean subjective = map.values().containsAll(codomain);
        if (!isFunction) {
            return "not a function";
        } else if ((injective) && (subjective)) {
            return "bijective";
        } else if (injective) {
            return "injective";
        } else if (subjective) {
            return "surjective";
        } else {
            return "neither injective nor surjective";
        }
    }

    private static String[] getValues(final String line) {
        return line.replace(" ", "").split("->");
    }

    private static Set<String> getInfo(final String line) {
        final Set<String> result = new HashSet<>();
        try (final Scanner in = new Scanner(line)) {
            in.next();
            while (in.hasNext()) {
                result.add(in.next());
            }
        }

        return result;
    }
}