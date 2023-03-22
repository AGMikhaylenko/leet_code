package easy.array;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * Runtime 13.73% Memory 47.41%
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(IntStream.of(nums).boxed().toList());
        return set.size() != nums.length;
    }
}
