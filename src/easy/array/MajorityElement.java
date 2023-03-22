package easy.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 * Runtime 14.43% Memory 12.67%
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.merge(i, 1, Integer::sum);
            } else {
                map.put(i, 1);
            }
        }

        return map.entrySet()
                .stream()
                .max(
                        Comparator.comparingInt(Map.Entry::getValue)
                )
                .get()
                .getKey();
    }
}
