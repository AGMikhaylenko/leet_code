package medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * Runtime 63.43% Memory 82.09%
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>());

        for (int right = nums.length - 1; right >= 0; right--) {
            List<List<Integer>> inner = new LinkedList<>();
            for (List<Integer> l : list) {
                List<Integer> dest = new LinkedList<>(l);
                dest.add(nums[right]);
                inner.add(dest);
            }
            list.addAll(inner);
        }

        return list;
    }
}
