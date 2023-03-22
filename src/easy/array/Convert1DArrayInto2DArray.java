package easy.array;

/**
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 * Runtime 40.30% Memory 25.52%
 */
public class Convert1DArrayInto2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][];
        }

        int[][] res = new int[m][n];

        for (int i = 0; i < original.length; i++) {
            res[i/n][i%n] = original[i];
        }

        return res;
    }
}
