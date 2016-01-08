import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FalseSecurity {

    private static final Map<Character, String> CHAR_TO_MORSE = new HashMap<Character, String>() {{
        this.put('A', ".-");   this.put('H', "...."); this.put('O', "---");  this.put('V', "...-");
        this.put('B', "-..."); this.put('I', "..");   this.put('P', ".--."); this.put('W', ".--");
        this.put('C', "-.-."); this.put('J', ".---"); this.put('Q', "--.-"); this.put('X', "-..-");
        this.put('D', "-..");  this.put('K', "-.-");  this.put('R', ".-.");  this.put('Y', "-.--");
        this.put('E', ".");    this.put('L', ".-.."); this.put('S', "...");  this.put('Z', "--..");
        this.put('F', "..-."); this.put('M', "--");   this.put('T', "-");    this.put('G', "--.");
        this.put('N', "-.");   this.put('U', "..-");  this.put('_', "..--"); this.put('.', "---.");
        this.put(',', ".-.-"); this.put('?', "----");
    }};

    private static final Map<String, Character> MORSE_TO_CHAR = reverseCharToMorse();

    private static Map<String, Character> reverseCharToMorse() {
        final Map<String, Character> result = new HashMap<>();
        for (final Map.Entry<Character, String> entry : CHAR_TO_MORSE.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    public static void main(final String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                System.out.println(decode(in.nextLine()));
            }
        }
    }

    private static String decode(final String line) {
        final int[] spaces = new int[line.length()];
        final StringBuilder morse = new StringBuilder();
        for (int i = 0; i < spaces.length; i++) {
            final String m = CHAR_TO_MORSE.get(line.charAt(i));
            spaces[i] = m.length();
            morse.append(m);
        }

        final StringBuilder result = new StringBuilder();
        for (int i = spaces.length - 1, j = 0; i >= 0; i--) {
            result.append(MORSE_TO_CHAR.get(morse.substring(j, j + spaces[i])));
            j += spaces[i];
        }

        return result.toString();
    }

}
