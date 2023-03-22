package easy.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/valid-anagram/
 * Runtime 35.20% Memory 43.94%
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (mapS.containsKey(c)) {
                mapS.merge(c, 1, Integer::sum);
            } else {
                mapS.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (mapT.containsKey(c)) {
                mapT.merge(c, 1, Integer::sum);
            } else {
                mapT.put(c, 1);
            }
        }

        return Objects.equals(mapS, mapT);
    }
}
