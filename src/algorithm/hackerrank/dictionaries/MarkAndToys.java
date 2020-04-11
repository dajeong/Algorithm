package algorithm.hackerrank.dictionaries;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 */
public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        int sum = 0;
        for (int price : prices) {
            sum += price;
            if (sum > k) {
                break;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int result = maximumToys(new int[]{1, 12, 5, 111, 200, 1000, 10}, 50);
        System.out.println(result);
    }
}
