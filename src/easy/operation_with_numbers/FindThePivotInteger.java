package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/find-the-pivot-integer/
 * Runtime 77.54% Memory 67.67%
 */
public class FindThePivotInteger {

    public int pivotInteger(int n) {
        int left = 1;

        int sum = 0;
        while (left != n) {
            if (sum < left) {
                sum += n;
                n--;
            } else {
                sum -= left;
                left++;
            }
        }

        return sum == 0 ? left : -1;
    }
}
