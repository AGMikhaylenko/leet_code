package hard.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * Runtime 50.73% Memory 48.36%
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.merge(c, 1, Integer::sum);
            } else {
                map.put(c, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(e -> {
                    sb.append(String.valueOf(e.getKey()).repeat(e.getValue()));
                });

        return sb.toString();
    }
}
