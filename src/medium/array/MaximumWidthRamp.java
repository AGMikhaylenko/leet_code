package medium.array;

/**
 *  https://leetcode.com/problems/maximum-width-ramp/
 *  Runtime 5.12% Memory 55.51%
 */
public class MaximumWidthRamp {

    public static void main(String[] args) {
        int[] nums = {6,0,8,2,1,5};
        int res = new MaximumWidthRamp().maxWidthRamp(nums);
        System.out.println(res);
    }

    public int maxWidthRamp(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length - max - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i] && j - i > max) {
                    max = j - i;
                }
            }
        }

        return max;
    }
}
