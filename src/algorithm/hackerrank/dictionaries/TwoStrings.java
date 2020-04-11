package algorithm.hackerrank.dictionaries;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {

    static String twoStrings(String s1, String s2) {

        for (int i = (int) 'a'; i < (int) 'z'; i++) {
            if (s1.indexOf((char)i) >= 0
                    && s2.indexOf((char)i) >= 0) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String result = twoStrings("hi", "world");
        System.out.println(result);
    }
}
