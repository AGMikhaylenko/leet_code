package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/power-of-four/
 * Runtime 100%, Memory 51.75%
 */
public class PowerOfFour {

    public static void main(String[] args) {
        int n = -4;
        boolean res = new PowerOfFour().isPowerOfTwo(n);
        System.out.println(res);
    }

    public boolean isPowerOfTwo(int n) {
        long l = 1;
        while (l <= n) {
            if (l == n) {
                return true;
            }

            l *= 4;
        }

        return false;
    }
}
