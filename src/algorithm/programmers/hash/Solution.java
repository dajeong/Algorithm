package algorithm.programmers.hash;

public class Solution {

	public static void main(String[] args) {
		BestAlbum bestAlbum = new BestAlbum();
		int[] solution = bestAlbum.solution(new String[]{"classic", "pop", "classic", "classic", "pop", "pop", "a", "b"},
				new int[]{500, 600, 150, 800, 2500, 600, 1000000, 20});
		print(solution);
	}

	private static void print(int[] something) {
		for (int aSomething : something) {
			System.out.print(aSomething + " ");
		}
		System.out.println();
	}
}
