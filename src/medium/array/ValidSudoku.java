package medium.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * Runtime 67.98% Memory 59.42%
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> valuesH = new HashSet<>();
        Set<Character> valuesV = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            valuesH.clear();
            valuesV.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (valuesH.contains(board[i][j])) {
                        return false;
                    } else {
                        valuesH.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (valuesV.contains(board[j][i])) {
                        return false;
                    } else {
                        valuesV.add(board[j][i]);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                valuesH.clear();
                for (int i2 = 0; i2 < 3; i2++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        if (board[i + i2][j + j2] != '.') {
                            if (valuesH.contains(board[i + i2][j + j2])) {
                                return false;
                            } else {
                                valuesH.add(board[i + i2][j + j2]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
