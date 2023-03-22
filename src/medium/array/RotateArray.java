package medium.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 * Runtime 66.84% Memory 92.81%
 */
public class RotateArray {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;

        new RotateArray().rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k %= size;

        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = nums[(i - k + size) % size];
        }

        for (int i=0;i<nums.length;i++){
            nums[i] = res[i];
        }
    }
}
