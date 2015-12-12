import static java.lang.Math.abs;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestSums {

	public static void main(final String[] args) {
		final StringBuilder sb = new StringBuilder();
		try (final Scanner in = new Scanner("4 -4 -3 -2 2 1 -3")) {
			int caseNumber = 1;
			while (in.hasNext()) {
				sb.append("Case ").append(caseNumber++).append(":\n");
				final int[] values = new int[in.nextInt()];
				for (int i = 0; i < values.length; i++) {
					values[i] = in.nextInt();
				}
				
				Arrays.sort(values);
				
				final int[] targets = new int[in.nextInt()];
				for (int i = 0; i < targets.length; i++) {
					targets[i] = in.nextInt();
				}

				for (final int target : targets) {
					sb
					.append("Closest sum to ")
					.append(target)
					.append(" is ")
					.append(getClosest(values, target))
					.append(".\n");
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}

	private static int getClosest(final int[] pairs, final int target) {
		int closest = Integer.MAX_VALUE;
		for (int x = 0; x < pairs.length; x++) {
			for (int y = x + 1; y < pairs.length; y++) {
				final int sum = pairs[x] + pairs[y];
				if (abs(closest - target) > abs(sum - target)) {
					closest = sum;
				} else if (sum > target) {
					break;
				}
			}
		}
		
		return closest;
	}

}
