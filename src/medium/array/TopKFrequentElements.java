package medium.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Runtime  Memory
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.merge(i, 1, Integer::sum);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> values = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int [] res = new int[k];
        int i = 0;
        for(int v: values){
            res[i++] = v;
        }
        return res;
    }
}
