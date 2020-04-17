package algorithm.programmers.practices;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class ToyCrane {

    private final Stack<Integer> bucket = new Stack<>();
    private int died = 0;

    public int solution(int[][] board, int[] moves) {
        for (int move : moves) {
            final int pickIndex = move - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][pickIndex] == 0) {
                    continue;
                }
                this.putBucket(board[j][pickIndex]);
                board[j][pickIndex] = 0;
                break;
            }
        }
        return died;
    }

    private void putBucket(int toy) {
        if (bucket.empty()) {
            bucket.push(toy);
            return;
        }
        final Integer peek = bucket.peek();
        if (!peek.equals(toy)) {
            bucket.push(toy);
            return;
        }
        bucket.pop();
        died += 2;
    }

    public static void main(String[] args) {
        int solution = new ToyCrane()
                .solution(new int[][]{{0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 3},
                                {0, 2, 5, 0, 1},
                                {4, 2, 4, 4, 2},
                                {3, 5, 1, 3, 1}},
                        new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        System.out.println(solution);
    }
}
