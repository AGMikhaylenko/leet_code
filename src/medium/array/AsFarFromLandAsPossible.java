package medium.array;

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 * Runtime 86.37% Memory 70.51%
 */
public class AsFarFromLandAsPossible {

    public static void main(String[] args) {
        int [][] grid = {
                {1,0,0},
                {0,0,0},
                {0,0,0}
        };
        int res = new AsFarFromLandAsPossible().maxDistance(grid);
        System.out.println(res);
    }

    public int maxDistance(int[][] grid) {
        boolean waterExists = false;
        boolean landExists = false;
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    waterExists = true;
                    grid[i][j] = Integer.MAX_VALUE;
                } else {
                    landExists = true;
                    grid[i][j] = 0;
                }
            }
        }

        if (!waterExists || !landExists) {
            return -1;
        }

        int count = 0;
        while (max == count) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == count) {
                        if (i > 0) {
                            grid[i - 1][j] = Integer.min(grid[i - 1][j], grid[i][j] + 1);
                            max = Integer.max(grid[i - 1][j], max);
                        }
                        if (i < grid.length - 1) {
                            grid[i + 1][j] = Integer.min(grid[i + 1][j], grid[i][j] + 1);
                            max = Integer.max(grid[i + 1][j], max);
                        }
                        if (j > 0) {
                            grid[i][j - 1] = Integer.min(grid[i][j - 1], grid[i][j] + 1);
                            max = Integer.max(grid[i][j - 1], max);
                        }
                        if (j < grid[i].length - 1) {
                            grid[i][j + 1] = Integer.min(grid[i][j + 1], grid[i][j] + 1);
                            max = Integer.max(grid[i][j + 1], max);
                        }
                    }
                }
            }
            count++;
        }

        return max;
    }
}
