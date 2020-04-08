package algorithm.hackerrank;

import java.util.function.Function;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 */
public class CountingValleys {
	public static final int SEA_LEVEL = 0;

	static int countingValleys(int n, String s) {
		int currentTrack = SEA_LEVEL;

		int countValley = 0;
		for (int i = 0; i < n; i++) {
			int nextTrack = Direction.valueOf(String.valueOf(s.charAt(i)))
					.walk(currentTrack);
			if (nextTrack == 0 && currentTrack < 0) {
				countValley++;
			}
			currentTrack = nextTrack;
		}
		return countValley;
	}

	enum Direction {
		U(v -> v + 1),
		D(v -> v - 1);

		private Function<Integer, Integer> function;

		Direction(Function<Integer, Integer> function) {
			this.function = function;
		}

		public Integer walk(Integer track) {
			return function.apply(track);
		}
	}

	public static void main(String[] args) {
		long result = countingValleys(8, "UDDDUDUU");
		System.out.println(result);
	}
}
