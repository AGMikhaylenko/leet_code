package medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
 * Runtime 9.42% Memory 29.84%
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.merge(c, 1, Integer::sum);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.merge(c, -1, Integer::sum);
            } else {
                map.put(c, -1);
            }
        }

        int pos = 0;
        int neg = 0;
        for (Integer i : map.values()) {
            if (i > 0) {
                pos += i;
            }
            if (i < 0) {
                neg += -1 * i;
            }
        }
        return Math.max(pos, neg);
    }
}
