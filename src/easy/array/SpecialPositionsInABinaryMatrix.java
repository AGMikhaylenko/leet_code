package easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 */
public class SpecialPositionsInABinaryMatrix {

    public static void main(String[] args) {
        int [][] a = {{0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0},{0,1,0,0,0,0,1,0},{0,1,0,0,0,0,0,0}};
        new SpecialPositionsInABinaryMatrix().numSpecial(a);
    }

    public int numSpecial(int[][] mat) {

        Set<Integer> columns = new HashSet<>();
        Set<Integer> goodColumns = new HashSet<>();
        Set<Integer> row = new HashSet<>();

        for (int i = 0; i < mat.length; i++) {
            row.clear();
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    row.add(j);
                }
            }
            if (row.size() == 1) {
                row.forEach(
                        c -> {
                            if (columns.contains(c)) {
                                goodColumns.remove(c);
                            } else {
                                columns.add(c);
                                goodColumns.add(c);
                            }
                        }
                );
            } else {
                columns.addAll(row);
                goodColumns.removeAll(row);
            }
        }

        return goodColumns.size();
    }
}
