package algorithm.baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1463
 */
public class P1463 {

    public int dp(int num, int[] numArr) {

        if (num == 1) {
            return 0;
        }

        numArr[num] = dp(num - 1, numArr) + 1;

        if (num % 2 == 0) {
            int tmp = numArr[num / 2] + 1;
            if (numArr[num] > tmp) {
                numArr[num] = tmp;
            }
        }

        if (num % 3 == 0) {
            int tmp = numArr[num / 3] + 1;
            if (numArr[num] > tmp) {
                numArr[num] = tmp;
            }
        }

        return numArr[num];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int[] dp = new int[num + 1];

        int answer = new P1463().dp(num, dp);

        System.out.println(answer);
    }
}
