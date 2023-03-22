package medium.array;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 * Runtime 61.70% Memory 35.86%
 */
public class WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        byte i;
        byte j;

        int[] result = new int[grid[0].length];

        for (byte index = 0; index < grid[0].length; index++) {
            i = 0;
            j = index;
            boolean isDeadEnd = false;

            while (i < grid.length && !isDeadEnd) {
                if (grid[i][j] == 1) {
                    if (j == grid[0].length - 1 || grid[i][j + 1] == -1) {
                        result[index] = -1;
                        isDeadEnd = true;
                    } else {
                        i++;
                        j++;
                    }
                } else {
                    if (j == 0 || grid[i][j - 1] == 1) {
                        result[index] = -1;
                        isDeadEnd = true;
                    } else {
                        i++;
                        j--;
                    }
                }
            }
            result[index] = isDeadEnd ? -1 : j;
        }

        return result;
    }
}
