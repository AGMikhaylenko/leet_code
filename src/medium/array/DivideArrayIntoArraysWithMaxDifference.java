package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
 * Runtime 99.06% Memory 6.12%
 */
public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        List<int[]> list = new ArrayList<>();
        int left = 0;
        int right = 1;

        for (; right < nums.length; ) {
            if (nums[right] - nums[left] > k) {
                left = right;
                right++;
            } else {
                right++;
            }


            if (right - left == 3) {
                int[] buf = new int[3];
                buf[0] = nums[left];
                buf[1] = nums[left + 1];
                buf[2] = nums[left + 2];
                list.add(buf);
                left = right;
                right++;
            }
        }

        if (list.size() * 3 != nums.length) {
            return new int[0][];
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
