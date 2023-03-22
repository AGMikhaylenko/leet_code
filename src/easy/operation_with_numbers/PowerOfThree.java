package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/power-of-three/
 * Runtime 91.59%, Memory 62.75%
 */
public class PowerOfThree {

    public static void main(String[] args) {
        int n = -4;
        boolean res = new PowerOfThree().isPowerOfTwo(n);
        System.out.println(res);
    }

    public boolean isPowerOfTwo(int n) {
        long l = 1;
        while (l <= n) {
            if (l == n) {
                return true;
            }

            l *= 3;
        }

        return false;
    }
}
