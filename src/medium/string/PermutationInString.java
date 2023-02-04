package medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int lengthS1 = s1.length();

        Map<Character, Integer> mapS2 = null;
        Map<Character, Integer> mapS1 = convertStringToVap(s1);

        char[] symbolsS2 = s2.toCharArray();

        for (int i = 0; i <= s2.length() - lengthS1; i++) {
            if (i == 0) {
                mapS2 = convertStringToVap(s2.substring(i, i + lengthS1));
            } else {
                mapS2.merge(symbolsS2[i - 1], -1, Integer::sum);
                mapS2.merge(symbolsS2[i + lengthS1 - 1], 1, Integer::sum);
            }
            if (mapsIsEquals(mapS2, mapS1)) {
                return true;
            }
        }

        return false;
    }

    private boolean mapsIsEquals(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {
        for (Map.Entry<Character, Integer> entryB : mapB.entrySet()) {
            if (!entryB.getValue().equals(mapA.get(entryB.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> convertStringToVap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.merge(c, 1, Integer::sum);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
