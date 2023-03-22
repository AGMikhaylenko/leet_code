package easy.array;

/**
 * https://leetcode.com/problems/matrix-diagonal-sum/
 * Runtime 100% Memory 86.32%
 */
public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (i != mat.length - 1 - i) {
                sum += mat[i][mat.length - 1 - i];
            }
        }

        return sum;
    }
}
