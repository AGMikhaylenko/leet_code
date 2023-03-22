package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shuffle-the-array/
 * Runtime 100%, Memory 80.82%
 */
public class ShuffleTheArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        int n = 2;

        System.out.println(Arrays.toString(new ShuffleTheArray().shuffle(nums, n)));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int shift = 0;

        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[i - shift];
            } else {
                shift++;
                res[i] = nums[i + n - shift];
            }
        }
        return res;
    }
}
