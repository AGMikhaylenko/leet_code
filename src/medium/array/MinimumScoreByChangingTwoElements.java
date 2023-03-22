package medium.array;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/biweekly-contest-98/problems/minimum-score-by-changing-two-elements/
 */
public class MinimumScoreByChangingTwoElements {

    public static void main(String[] args) {
        int [] nums = {58,42,8,75,28};
        int res = new MinimumScoreByChangingTwoElements().minimizeSum(nums);
        System.out.println(res);
    }

    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        return Integer.min(
                Integer.min(nums[nums.length-3] - nums[0], nums[nums.length-1] - nums[2]),
                nums[nums.length-2] - nums[1]
        );
    }
}
