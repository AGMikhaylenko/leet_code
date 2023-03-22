package easy.operation_with_numbers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/
 * Runtime 99.51% Memory 99.2%
 */
public class LargestPerimeterTriangle {

    public static void main(String[] args) {

    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }
}
