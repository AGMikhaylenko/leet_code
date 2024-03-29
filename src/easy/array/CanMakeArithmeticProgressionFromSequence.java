package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 * Runtime 99.53% Memory 96.92%
 */
public class CanMakeArithmeticProgressionFromSequence {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int delta = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != delta) {
                return false;
            }
        }

        return true;
    }
}
