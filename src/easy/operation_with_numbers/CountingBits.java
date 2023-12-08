package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/counting-bits/?envType=study-plan-v2&envId=leetcode-75
 * Runtime  Memory
 */
public class CountingBits {

    public static void main(String[] args) {
        new CountingBits().countBits(5);
    }

    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        int d = 2;

        for (int i = 1; i < n + 1; i++) {
            a[i] = 1 + a[i % d];
            if (i == 2 * d) {
                d *= 2;
            }
        }

        return a;
    }
}
