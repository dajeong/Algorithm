package algorithm.hackerrank;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 */
public class RepeatedString {

	public static final String NOT_A = "[^a]";

	static long repeatedString(String s, long n) {
		int length = s.length();
		long count = s.replaceAll(NOT_A, "").length();
		count = count * (n / length);
		long remain = n % length;
		count += s.substring(0, (int) remain).replaceAll(NOT_A, "").length();
		return count;
	}

	public static void main(String[] args) {
		long result = repeatedString("abcdab", 1000000000000L);	// 333333333333
		System.out.println(result);
	}
}
