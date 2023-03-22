package medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * Runtime 100% Memory 38.1%
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int length = matrix.length * matrix[0].length;
        boolean[][] checked = new boolean[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        Direction direction = Direction.RIGHT;
        int i = 0;
        int j = -1;

        while (length > 0) {
            i += direction.x;
            j += direction.y;

            result.add(matrix[i][j]);
            checked[i][j] = true;

            switch (direction) {
                case RIGHT:
                    if (j == matrix[0].length - 1 || checked[i][j + 1]) {
                        direction = Direction.BOTTOM;
                    }
                    break;
                case BOTTOM:
                    if (i == matrix.length - 1 || checked[i + 1][j]) {
                        direction = Direction.LEFT;
                    }
                    break;
                case LEFT:
                    if (j == 0 || checked[i][j - 1]) {
                        direction = Direction.TOP;
                    }
                    break;
                case TOP:
                    if (i == 0 || checked[i - 1][j]) {
                        direction = Direction.RIGHT;
                    }
                    break;

            }

            length--;
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
