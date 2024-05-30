package hard.common;

/**
 * https://leetcode.com/problems/consecutive-numbers-sum/
 */
public class ConsecutiveNumbersSum {

    public static void main(String[] args) {
        new ConsecutiveNumbersSum().consecutiveNumbersSum(3);
    }

    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int div = 2;
        int goal;

        while (true) {
            goal = n / div;
            if (goal < div / 2 + div % 2) {
                return res + 1;
            }

            if (div % 2 == 0) {
                goal = goal * div + div / 2;
            } else {
                goal *= div;
            }

            if (goal == n) {
                res++;
            }
            div++;
        }
    }
}
