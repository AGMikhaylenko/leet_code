package easy.array;

/**
 * https://leetcode.com/problems/monotonic-array/
 * Runtime 70.14% Memory 56.92%
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        Boolean asc = null;

        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (asc == null) {
                if (nums[i] < nums[i + 1]) {
                    asc = true;
                }

                if (nums[i] > nums[i + 1]) {
                    asc = false;
                }
            } else {
                if (asc && nums[i] > nums[i + 1]) {
                    return false;
                }
                if (!asc && nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
