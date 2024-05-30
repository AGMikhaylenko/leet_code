package easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.merge(i, 1, Integer::sum);
            } else {
                map.put(i, 1);
            }
        }

        return map.keySet().size() == map.values().stream().distinct().count();
    }
}
