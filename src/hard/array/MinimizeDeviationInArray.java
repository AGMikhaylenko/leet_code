package hard.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimize-deviation-in-array/
 * Runtime 20.37% Memory 74.7%
 */
public class MinimizeDeviationInArray {

    public static void main(String[] args) {
        int[] nums = {399, 908, 648, 357, 693, 502, 331, 649, 596, 698};
        System.out.println(new MinimizeDeviationInArray().minimumDeviation(nums));
    }

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        int dev = Integer.MAX_VALUE;
        int max;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
            queue.offer(nums[i]);
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        boolean continued = true;
        while (continued) {
            continued = false;
            max = queue.poll();
            if (dev > max - min) {
                dev = max - min;
            }
            if (max % 2 == 0) {
                continued = true;
                max /= 2;
                if (min > max) {
                    min = max;
                }
                queue.offer(max);
            }
        }

        return dev;
    }
}
