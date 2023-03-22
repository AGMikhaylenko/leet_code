package medium.array;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Runtime 100% Memory 22.33%
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum < 0 && nums[i] > sum) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
}
