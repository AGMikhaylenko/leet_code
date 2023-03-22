package easy.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reshape-the-matrix/
 * Runtime 100%
 */
public class ReshapeTheMatrix {

    public static void main(String[] args) {
        int [][] res = new ReshapeTheMatrix().matrixReshape(new int [][] {{1,2},{3,4}},  1, 4);

        for(int []line:res){
            System.out.println(Arrays.toString(line));
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int column = mat[0].length;

        int count = rows * column;
        if (count != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < count; i++) {
            res[i / c][i % c] = mat[i / column][i % column];
        }

        return res;
    }
}
