package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * Runtime 13.5% Memory 73.11%
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        break;
                    }
                }
                if (j < nums.length) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }
}
