package algorithm.hackerrank.dictionaries;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {

	static void checkMagazine(String[] magazine, String[] note) {
		final Map<String, Integer> wordMap = new HashMap<>();
		for (String word : magazine) {
			wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
		}
		for (String word : note) {
			Integer wordCount = wordMap.get(word);
			if (wordCount == null || wordCount == 0) {
				System.out.println("No");
				return;
			}
			wordMap.put(word, wordCount - 1);
		}
		System.out.println("Yes");
    }

	public static void main(String[] args) {
		checkMagazine(new String[]{"two", "times", "three", "is", "not", "four"},
				new String[]{"two", "times", "two", "is", "four"});
	}
}
