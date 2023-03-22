package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * Runtime 100% Memory 54.89%
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    public static void main(String[] args) {
        int n = 4421;
        System.out.println(new SubtractTheProductAndSumOfDigitsOfAnInteger().subtractProductAndSum(n));
    }

    public int subtractProductAndSum(int n) {
        int res = 1;
        int sum = 0;

        while (n != 0) {
            res *= n % 10;
            sum += n % 10;
            n /= 10;
        }

        return res - sum;
    }
}
