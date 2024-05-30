package medium.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Runtime 6.81% Memory 97.41%
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[right.length - 1] = nums[nums.length - 1];

        int i = 1;
        for (; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
            right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - 1 - i];
        }

        nums[0] = right[1];
        nums[nums.length - 1] = left[left.length - 2];
        for (i = 1; i < nums.length - 1; i++) {
            nums[i] = left[i - 1] * right[i + 1];
        }

        return nums;
    }
}
