package algorithm.hackerrank.greedy;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/greedy-florist/problem
 */
public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {
        final Integer[] costs = IntStream.of(c).boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            answer += (1 + (i / k)) * costs[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int minimumCost = getMinimumCost(2, new int[]{2, 5, 6});
        System.out.println(minimumCost);
    }
}
