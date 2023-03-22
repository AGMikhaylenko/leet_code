package medium.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "ABCCCCC";
        int k = 2;

        int res = new LongestRepeatingCharacterReplacement().characterReplacement(s, k);
        System.out.println(res);
    }

    public int characterReplacement(String s, int k) {
        if (k == s.length()) {
            return k;
        }

        Map<Character, Integer> map = null;

        int start = 0;
        int end = k;
        char[] symbols = s.toCharArray();

        int max = 0;
        char currentMax;
        char next;
        boolean swap = false;

        while (end < s.length() - 1) {
            if (map == null || swap) {
                map = new HashMap<>();
                for (int i = start; i <= end; i++) {
                    if (map.containsKey(symbols[i])) {
                        map.merge(symbols[i], 1, Integer::sum);
                    } else {
                        map.put(symbols[i], 1);
                    }
                }
                swap = false;
            } else {
                Map.Entry<Character, Integer> maxEntry = getMaxFromMap(map);
                max = maxEntry.getValue();
                if (start + max + k - 1 > end) {
                    end = start + max + k - 1;
                    swap = true;

                } else {
                    currentMax = maxEntry.getKey();

                    next = symbols[end + 1];
                    if (map.containsKey(next)) {
                        map.merge(next, 1, Integer::sum);
                    } else {
                        map.put(next, 1);
                    }

                    if (next == currentMax) {
                        max++;
                    }

                    if (next != currentMax || end - start + 2 > max + k) {
                        map.merge(symbols[start], -1, Integer::sum);
                        start++;
                    }
                    end++;
                }
            }
        }

        map = new HashMap<>();
        for (int i = start; i < symbols.length; i++) {
            if (map.containsKey(symbols[i])) {
                map.merge(symbols[i], 1, Integer::sum);
            } else {
                map.put(symbols[i], 1);
            }
        }
        max = getMaxFromMap(map).getValue();

        return Integer.max(
                s.length() - start,
                Integer.min(max + k, s.length())
        );
    }

    private Map.Entry<Character, Integer> getMaxFromMap(Map<Character, Integer> map) {
        return map
                .entrySet()
                .stream()
                .max(new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                })
                .get();
    }
}
