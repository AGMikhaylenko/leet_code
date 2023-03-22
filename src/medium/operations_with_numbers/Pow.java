package medium.operations_with_numbers;

/**
 * https://leetcode.com/problems/powx-n/
 * Runtime 100% Memory 66.84%
 */
public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        double b = myPow(x, n / 2);
        if (n % 2 == 0) {
            return b * b;
        } else {
            if (n > 0) {
                return x * b * b;
            } else {
                return b * b / x;
            }
        }
    }
}
