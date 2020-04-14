package algorithm.hackerrank.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/two-arrays/problem
 */
public class PermutingTwoArrays {

	static String twoArrays(int k, int[] A, int[] B) {
		Integer[] reverseA = IntStream.of(A).boxed().toArray(Integer[]::new);
		Arrays.sort(reverseA, Comparator.reverseOrder());
		Arrays.sort(B);

		int length = A.length;
		for (int i = 0; i < length; i++) {
			if (B[i] + reverseA[i] < k) {
				return "NO";
			}
		}
		return "YES";
	}

	public static void main(String[] args) {
		String s = twoArrays(10, new int[]{2, 1, 3}, new int[]{7, 8, 9});
		System.out.println(s);
		s = twoArrays(5, new int[]{1, 2, 2, 1}, new int[]{3, 3, 3, 4});
		System.out.println(s);
	}
}
