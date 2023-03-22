package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/power-of-two/
 * Runtime 100%, Memory 43.94%
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        int n = -4;
        boolean res = new PowerOfTwo().isPowerOfTwo(n);
        System.out.println(res);
    }

    public boolean isPowerOfTwo(int n) {
        long l = 1;
        while (l <= n) {
            if (l == n) {
                return true;
            }

            l *= 2;
        }

        return false;
    }
}
