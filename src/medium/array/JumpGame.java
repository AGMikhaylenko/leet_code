package medium.array;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int curr = nums.length - 1;
        if (curr == 0) {
            return true;
        }

        for (int i = curr - 1; i >= 0; i--) {
            if (nums[i] >= curr - i) {
                curr = i;
            }
        }

        return curr == 0;
    }
}
