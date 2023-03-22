package medium.array;

import java.util.Random;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 * Runtime 95.22% Memory 11.80%
 */
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int mid = 0;
        int left = Integer.MIN_VALUE;
        int right = 0;
        int count;
        int sum;

        for (int i : weights) {
            right += i;
            if (left < i) {
                left = i;
            }
        }

        while (left < right) {
            mid = left + (right - left) / 2;
            count = 1;
            sum = 0;
            for (int i = 0; i < weights.length; i++) {
                if (sum + weights[i] <= mid) {
                    sum += weights[i];
                } else {
                    sum = weights[i];
                    count++;
                }
            }
            if (count > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
