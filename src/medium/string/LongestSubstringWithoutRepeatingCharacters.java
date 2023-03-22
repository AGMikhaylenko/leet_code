package medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Runtime 21.14% Memory 53.65%
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;

        char[] symbols = s.toCharArray();
        Map<Character, Integer> currentMap = null;

        while (end < s.length() - 1) {
            if (currentMap == null) {
                currentMap = new HashMap<>();
                currentMap.put(symbols[start], 1);
            }

            char next = symbols[++end];
            if (currentMap.containsKey(next)) {
                currentMap.merge(next, 1, Integer::sum);
            } else {
                currentMap.put(next, 1);
            }

            if (!isUnique(currentMap)) {
                currentMap.merge(symbols[start++], -1, Integer::sum);
            }
        }

        return s.length() - start;
    }

    private boolean isUnique(Map<Character, Integer> map) {
        return map.values()
                .stream()
                .noneMatch(i -> i > 1);
    }
}
