package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/arithmetic-subarrays/
 * Runtime 82.46% Memory 13.86%
 */
public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>(l.length);

        for (int i = 0; i < l.length; i++) {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arr);
            boolean res = true;
            int delta = -1;
            for (int j = 1; j < arr.length; j++) {
                if (delta == -1) {
                    delta = arr[j] - arr[j - 1];
                } else {
                    if (arr[j] - arr[j - 1] != delta) {
                        res = false;
                        break;
                    }
                }
            }
            list.add(res);
        }

        return list;
    }
}
