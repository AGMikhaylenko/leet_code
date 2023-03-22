package medium.array;

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * Runtime 57.99% Memory 41.69%
 */
public class NumberOfZeroFilledSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        int zeros = 0;
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                if (zeros > 0) {
                    res += getSum(zeros);
                    zeros = 0;
                }
            }
            if (i == nums.length - 1) {
                res += getSum(zeros);
            }
        }
        return res;
    }

    private long getSum(int r) {
        long sum = 0;
        for (int i = 1; i <= r; i++) {
            sum += i;
        }
        return sum;
    }
}
