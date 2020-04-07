package algorithm.hackerrank;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 */
public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jump = -1;
        for (int i = 0; i < c.length; i++) {
            jump++;
            if (i + 2 < c.length && c[i + 2] == 0) {
                i++;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        int result = jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0});
        System.out.println(result);
    }
}
