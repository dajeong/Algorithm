package algorithm.hackerrank.arrays;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class Hourglass {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int height = arr.length - 2;
		int width = arr[0].length - 2;
		int max = -63;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int sum = arr[i][j] 	+ arr[i][j + 1] 	+ arr[i][j + 2]
										+ arr[i + 1][j + 1]
						+ arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				max = sum > max ? sum : max;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		long result = hourglassSum(new int[][]{{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0},
				{0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}});
//		long result = hourglassSum(new int[][]{
//				{-9, -9, -9, 1, 1, 1},
//				{0,  -9,  0, 4, 3, 2},
//				{-9, -9, -9, 1, 2, 3},
//				{0, 0, 8, 6, 6, 0},
//				{0, 0, 0, -2, 0, 0},
//				{0, 0, 1, 2, 4, 0}});
		System.out.println(result);
	}
}
