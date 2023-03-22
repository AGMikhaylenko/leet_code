package easy.array;

/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 * Runtime 100% Memory 29.37%
 */
public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int res = 0;
        short count = 0;
        int i = 0;

        while (i < arr.length && count != k) {
            res++;
            if (res == arr[i]) {
                i++;
            } else {
                count++;
            }
        }

        if (count < k) {
            return res + (k - count);
        }
        return res;
    }
}
