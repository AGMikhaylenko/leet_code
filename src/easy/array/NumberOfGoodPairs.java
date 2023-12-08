package easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 * Runtime 81.92% Memory 6.62%
 */
public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.merge(i, 1, Integer::sum);
            } else {
                map.put(i, 1);
            }
        }

        return map.values()
                .stream()
                .map(v -> {
                    int s = 0;
                    for (int i = 1; i < v; i++) {
                        s += i;
                    }
                    return s;
                })
                .reduce(0, Integer::sum);
    }
}
