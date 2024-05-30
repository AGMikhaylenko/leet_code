package medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
 */
public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    public int[][] onesMinusZeros(int[][] grid) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> columns = new HashMap<>();

        int n;
        for (int i = 0; i < grid.length; i++) {
            n = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    n++;
                    if (columns.containsKey(j)) {
                        columns.merge(j, 1, Integer::sum);
                    } else {
                        columns.put(j, 1);
                    }
                }
            }
            rows.put(i, n);
        }

        int[][] res = new int[grid.length][grid[0].length];
        int m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = 2 * rows.getOrDefault(i, 0) + 2 * columns.getOrDefault(j, 0) - m - n;
            }
        }

        return res;
    }
}
