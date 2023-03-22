package easy.array;

/**
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 * Runtime 26.87% Memory 70.36%
 */
public class CountHillsAndValleysInAnArray {


    public int countHillValley(int[] nums) {
        Boolean isHill = null;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (isHill == null) {
                if (nums[i + 1] < nums[i]) {
                    isHill = false;
                }

                if (nums[i + 1] > nums[i]) {
                    isHill = true;
                }
            } else {
                if (isHill && nums[i + 1] < nums[i]) {
                    count++;
                    isHill = false;
                }
                if (!isHill && nums[i + 1] > nums[i]) {
                    count++;
                    isHill = true;
                }
            }
        }

        return count;
    }
}
