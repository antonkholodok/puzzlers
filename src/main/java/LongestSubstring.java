import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> observedChars = new HashSet<>();

        int length = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            if (observedChars.contains(s.charAt(end))) {
                observedChars.remove(s.charAt(start++));
                continue;
            }
            observedChars.add(s.charAt(end++));
            length = Math.max(length, observedChars.size());
        }

        return length;
    }
}
