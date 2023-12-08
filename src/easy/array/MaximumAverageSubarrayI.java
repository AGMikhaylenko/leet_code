package easy.array;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
 * Runtime 100% Memory 45.95%
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int buf = sum;
        for (int i = k; i < nums.length; i++) {
            buf += nums[i] - nums[i - k];
            if (buf > sum) {
                sum = buf;
            }
        }

        return (double) sum / k;
    }
}
