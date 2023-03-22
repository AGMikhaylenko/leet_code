package medium.array;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * Runtime 21.28% Memory 26.75%
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int[] buf = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            buf[i] = nums[i];
            buf[i + nums.length] = nums[i];
        }
        int n;
        for (int i = 0; i < nums.length; i++) {
            n = -1;
            for (int j = i + 1; j < buf.length; j++) {
                if (buf[j] > nums[i]) {
                    n = buf[j];
                    break;
                }
            }
            nums[i] = n;
        }
        return nums;
    }
}
