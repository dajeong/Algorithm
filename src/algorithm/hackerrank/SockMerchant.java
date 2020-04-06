package algorithm.hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        final Map<Integer, Integer> socksBox = new HashMap<>();
        for (int i = 0; i < n; i++) {
            socksBox.put(ar[i], socksBox.getOrDefault(ar[i], 0) + 1);
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : socksBox.entrySet()) {
            total += entry.getValue() / 2;
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        int result = sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        System.out.println(result);
    }
}
