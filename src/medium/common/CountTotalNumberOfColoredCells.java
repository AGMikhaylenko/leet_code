package medium.common;

/**
 * https://leetcode.com/contest/biweekly-contest-99/problems/count-total-number-of-colored-cells/
 */
public class CountTotalNumberOfColoredCells {

    public long coloredCells(int n) {
        long res = 1;

        for (int i = 2; i <= n; i++) {
            res += (long) 4 * (i - 1);
        }

        return res;
    }
}
