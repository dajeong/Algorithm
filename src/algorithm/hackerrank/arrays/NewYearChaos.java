package algorithm.hackerrank.arrays;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class NewYearChaos {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int[] bribeCountArr = new int[q.length];
		int bribeSum = 0;
		while (true) {
			boolean swap = false;
			for (int i = 0; i < q.length - 1; i++) {
				if (q[i] > q[i + 1]) {
					bribeCountArr[q[i] - 1] += 1;
					if (bribeCountArr[q[i] - 1] == 3) {
						System.out.println("Too chaotic");
						return;
					}
					int temp = q[i];
					q[i] = q[i + 1];
					q[i + 1] = temp;
					bribeSum++;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
		System.out.println(bribeSum);
	}

	public static void main(String[] args) {
		minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});	// 7
		minimumBribes(new int[]{2, 5, 1, 3, 4});	// Too chaotic
	}
}
