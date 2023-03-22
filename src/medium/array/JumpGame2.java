package medium.array;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * Runtime 31.30% Memory 55.59%
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int[] steps = {2,3,0,1,4};
        int res = new JumpGame2().jump(steps);
        System.out.println(res);
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int min;
        int j;
        if (n == 1) {
            nums[0] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            min = Integer.MAX_VALUE - 1;
            for (j = i + 1; j <= i + nums[i] && j < n; j++) {
                if (j == n - 1) {
                    min = 0;
                } else {
                    if (nums[j] < min) {
                        min = nums[j];
                    }
                }
            }
            nums[i] = ++min;
        }

        return nums[0];
    }
}
