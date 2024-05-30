package easy.array;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Runtime 100% Memory 46.98%
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int indexNegative = -1;
        int indexPositive = res.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                indexPositive = i;
                indexNegative = i - 1;
                break;
            }
        }
        if (indexPositive == res.length) {
            indexNegative = res.length - 1;
        }

        for (int i = 0; i < res.length; i++) {
            if (indexNegative < 0) {
                res[i] = nums[indexPositive] * nums[indexPositive];
                indexPositive++;
                continue;
            }

            if (indexPositive >= res.length) {
                res[i] = nums[indexNegative] * nums[indexNegative];
                indexNegative--;
                continue;
            }

            if (nums[indexPositive] + nums[indexNegative] < 0) {
                res[i] = nums[indexPositive] * nums[indexPositive];
                indexPositive++;
            } else {
                res[i] = nums[indexNegative] * nums[indexNegative];
                indexNegative--;
            }
        }

        return res;
    }
}
