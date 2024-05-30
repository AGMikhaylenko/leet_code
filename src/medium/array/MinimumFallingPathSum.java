package medium.array;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * Runtime 68.64% Memory 57.99%
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        final int n = matrix.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int res = matrix[i - 1][j];
                if (j > 0) {
                    res = Math.min(res, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    res = Math.min(res, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += res;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[n - 1][i]);
        }

        return min;
    }
}
