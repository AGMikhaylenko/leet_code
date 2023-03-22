package easy.array;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/third-maximum-number/
 * Runtime 18.14% Memory 50.88%
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        nums = IntStream.of(nums)
                .distinct()
                .sorted()
                .toArray();
        return nums.length > 2 ? nums[nums.length - 3] : nums[nums.length - 1];
    }
}
