import java.util.Scanner;

public class Display {

	public static void main(final String[] args) {
		try (final Scanner in = new Scanner(System.in)) {
			final String[][] digits = {
				{"+---+", "|   |", "|   |", "+   +", "|   |", "|   |", "+---+"},
				{"    +", "    |", "    |", "    +", "    |", "    |", "    +"},
				{"+---+", "    |", "    |", "+---+", "|    ", "|    ", "+---+"},
				{"+---+", "    |", "    |", "+---+", "    |", "    |", "+---+"},
				{"+   +", "|   |", "|   |", "+---+", "    |", "    |", "    +"},
				{"+---+", "|    ", "|    ", "+---+", "    |", "    |", "+---+"},
				{"+---+", "|    ", "|    ", "+---+", "|   |", "|   |", "+---+"},
				{"+---+", "    |", "    |", "    +", "    |", "    |", "    +"},
				{"+---+", "|   |", "|   |", "+---+", "|   |", "|   |", "+---+"},
				{"+---+", "|   |", "|   |", "+---+", "    |", "    |", "+---+"}
			};
			
			String time;
			while (!(time = in.nextLine()).equals("end")) {
				final int first = Character.digit(time.charAt(0), 10);
				final int second = Character.digit(time.charAt(1), 10);

				final int third = Character.digit(time.charAt(3), 10);
				final int fourth = Character.digit(time.charAt(4), 10);

				for (int i = 0; i < 7; i++) {
					System.out.print(digits[first][i] + "  " + digits[second][i]);
					System.out.print(((i == 2) || (i == 4)) ? "  o  " : "     ");
					System.out.println(digits[third][i] + "  " + digits[fourth][i]);
				}
				
				System.out.println("\n");
			}
			
			System.out.println("end");
		}
	}
}
