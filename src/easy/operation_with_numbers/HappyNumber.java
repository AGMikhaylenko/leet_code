package easy.operation_with_numbers;

/**
 * Hardcode!!!
 * https://leetcode.com/problems/happy-number/
 * Runtime 88.36% Memory 80.18%
 */
public class HappyNumber {

    public static void main(String[] args) {
        boolean res = new HappyNumber().isHappy(19);
        System.out.println(res);
    }

    public boolean isHappy(int n) {
        int sum;
        for (int i = 0; i < 50; i++) {
            sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }

        return false;
    }
}
