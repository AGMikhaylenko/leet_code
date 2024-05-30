package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }
}
