package easy.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 * Runtime 19.23% Memory 28.18%
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.merge(i, 1, Integer::sum);
            } else {
                map.put(i, 1);
            }
        }


        int maxDegree = map.values()
                .stream().max(Comparator.naturalOrder())
                .get();

        List<Integer> numbersWithMaxDegree = map.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(maxDegree))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = 0;

        for (Integer d : numbersWithMaxDegree) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == d) {
                    left = i;
                    break;
                }
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == d) {
                    right = i;
                    break;
                }
            }
            result.add(right - left + 1);
        }

        return Collections.min(result);
    }
}
