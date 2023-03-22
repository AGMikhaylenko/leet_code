package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (ransomMap.containsKey(c)) {
                ransomMap.merge(c, 1, Integer::sum);
            } else {
                ransomMap.put(c, 1);
            }
        }

        for (char c : magazine.toCharArray()) {
            if (ransomMap.containsKey(c)) {
                ransomMap.merge(c, -1, Integer::sum);
            }
        }

        return ransomMap.values()
                .stream()
                .allMatch(v -> v <= 0);
    }
}
