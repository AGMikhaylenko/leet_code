package hard.array;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * Runtime 100% Memory 85.84%
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int prevMin;
        int min = 0;
        boolean reverse = false;

        do {
            prevMin = min;
            if (reverse) {
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (nums[i] - min == 1) {
                        min = nums[i];
                    }
                }
            } else {
                for (int i : nums) {
                    if (i - min == 1) {
                        min = i;
                    }
                }
            }
            reverse = !reverse;
        } while (min != prevMin);

        return ++min;
    }
}
