package medium.array;

import java.util.Arrays;

/**
 *  https://leetcode.com/problems/spiral-matrix-ii/
 *  Runtime 100% Memory 63.37%
 */
public class SpiralMatrix2 {

    public static void main(String[] args) {
        int n = 20;
        int[][] res = new SpiralMatrix2().generateMatrix(n);
        for (int[] line : res) {
            System.out.println(Arrays.toString(line));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        SpiralMatrix2.Direction direction = SpiralMatrix2.Direction.RIGHT;
        int i = 0;
        int j = -1;

        for (int value = 1; value <= n * n; value++) {
            i += direction.x;
            j += direction.y;

            result[i][j] = value;

            switch (direction) {
                case RIGHT:
                    if (j == result[0].length - 1 || result[i][j + 1] != 0) {
                        direction = SpiralMatrix2.Direction.BOTTOM;
                    }
                    break;
                case BOTTOM:
                    if (i == result.length - 1 || result[i + 1][j] != 0) {
                        direction = SpiralMatrix2.Direction.LEFT;
                    }
                    break;
                case LEFT:
                    if (j == 0 || result[i][j - 1] != 0) {
                        direction = SpiralMatrix2.Direction.TOP;
                    }
                    break;
                case TOP:
                    if (i == 0 || result[i - 1][j] != 0) {
                        direction = SpiralMatrix2.Direction.RIGHT;
                    }
                    break;

            }
        }
        return result;
    }

    enum Direction {
        RIGHT((byte) 0, (byte) 1),
        BOTTOM((byte) 1, (byte) 0),
        LEFT((byte) 0, (byte) -1),
        TOP((byte) -1, (byte) 0);

        final byte x;
        final byte y;


        Direction(byte x, byte y) {
            this.x = x;
            this.y = y;
        }
    }
}
