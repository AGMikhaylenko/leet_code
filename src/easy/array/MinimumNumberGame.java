package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-game/
 * Runtime 44.82% Memory 5.12%
 */
public class MinimumNumberGame {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        int buf;

        for (int i = 1; i < nums.length; i += 2) {
            buf = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = buf;
        }

        return nums;
    }
}
