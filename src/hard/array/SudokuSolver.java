package hard.array;

import java.util.*;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * Not solved
 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };

        new SudokuSolver().solveSudoku(board);

        for (char[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }

    private final Set<Character> possible = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public void solveSudoku(char[][] board) {
        Set<Character>[] valuesH = new HashSet[9];
        Set<Character>[] valuesV = new HashSet[9];
        Set<Character>[] valuesQ = new HashSet[9];

        Set<Character>[][] matrix = new HashSet[9][9];
        int count = fillSetsAndCountingFilledCells(
                valuesH,
                valuesV,
                valuesQ,
                matrix,
                board
        );

        int i;
        int j;
        boolean isSuccess;
        int index;
        int qI;
        int qJ;

        while (count != 81) {
            isSuccess = false;
            //The first variant
            for (i = 0; i < 9; i++) {
                for (j = 0; j < 9; j++) {
                    if (matrix[i][j] == null) {
                        continue;
                    }

                    getPossibleValues(
                            matrix[i][j],
                            valuesH[i],
                            valuesV[j],
                            valuesQ[i / 3 * 3 + j / 3]
                    );

                    if (matrix[i][j].size() == 1) {
                        char c = matrix[i][j].toArray(Character[]::new)[0];
                        board[i][j] = c;
                        valuesH[i].add(c);
                        valuesV[j].add(c);
                        valuesQ[i / 3 * 3 + j / 3].add(c);
                        count++;
                        matrix[i][j] = null;
                        isSuccess = true;
                    }
                }
            }

            if (isSuccess) {
                continue;
            }

            //check unique values in H
            Map<Character, List<Integer>> map = new HashMap<>();
            for (i = 0; i < 9 && !isSuccess; i++) {
                clearMap(map);
                for (j = 0; j < 9; j++) {
                    if (matrix[i][j] == null) {
                        continue;
                    }
                    for (char c : matrix[i][j]) {
                        List<Integer> list = map.get(c);
                        list.add(j);
                    }
                }

                for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                    if (entry.getValue().size() == 1) {
                        char c = entry.getKey();
                        index = entry.getValue().get(0);
                        board[i][index] = c;
                        valuesH[i].add(c);
                        valuesV[index].add(c);
                        valuesQ[i / 3 * 3 + index / 3].add(c);
                        count++;
                        isSuccess = true;
                        break;
                    }
                }
            }

            if (isSuccess) {
                continue;
            }

            //check unique values in V
            for (j = 0; j < 9 && !isSuccess; j++) {
                clearMap(map);
                for (i = 0; i < 9; i++) {
                    if (matrix[i][j] == null) {
                        continue;
                    }
                    for (char c : matrix[i][j]) {
                        List<Integer> list = map.get(c);
                        list.add(i);
                    }
                }

                for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                    if (entry.getValue().size() == 1) {
                        char c = entry.getKey();
                        index = entry.getValue().get(0);
                        board[index][j] = c;
                        valuesH[index].add(c);
                        valuesV[j].add(c);
                        valuesQ[index / 3 * 3 + j / 3].add(c);
                        count++;
                        isSuccess = true;
                        break;
                    }
                }
            }

            if (isSuccess) {
                continue;
            }

            //check unique values in Q
            for (i = 0; i < 9 && !isSuccess; i++) {
                clearMap(map);
                for (j = 0; j < 9; j++) {
                    qI = i / 3 * 3 + j / 3;
                    qJ = i % 3 * 3 + j % 3;
                    if (matrix[qI][qJ] == null) {
                        continue;
                    }
                    for (char c : matrix[qI][qJ]) {
                        List<Integer> list = map.get(c);
                        list.add(j);
                    }
                }

                for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                    if (entry.getValue().size() == 1) {
                        char c = entry.getKey();
                        index = entry.getValue().get(0);
                        qI = i / 3 * 3 + index / 3;
                        qJ = i % 3 * 3 + index % 3;
                        board[qI][qJ] = c;
                        valuesH[qI].add(c);
                        valuesV[qJ].add(c);
                        valuesQ[i].add(c);
                        count++;
                        isSuccess = true;
                        break;
                    }
                }
            }
            if(count==51){
                break;
            }
        }

    }

    private int fillSetsAndCountingFilledCells(Set<Character>[] valuesH,
                                               Set<Character>[] valuesV,
                                               Set<Character>[] valuesQ,
                                               Set<Character>[][] matrix,
                                               char[][] board) {
        int count = 0;

        for (int i = 0; i < 9; i++) {
            valuesH[i] = new HashSet<>();
            valuesV[i] = new HashSet<>();
            valuesQ[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    matrix[i][j] = new HashSet<>();
                } else {
                    valuesH[i].add(board[i][j]);
                    valuesV[j].add(board[i][j]);
                    valuesQ[i / 3 * 3 + j / 3].add(board[i][j]);
                    count++;
                }
            }
        }

        return count;
    }

    private void getPossibleValues(
            Set<Character> cell,
            Set<Character> valuesH,
            Set<Character> valuesV,
            Set<Character> valuesQ
    ) {
        cell.clear();
        for (Character c : possible) {
            if (!valuesH.contains(c)
                    && !valuesV.contains(c)
                    && !valuesQ.contains(c)) {
                cell.add(c);
            }
        }
    }

    private void clearMap(Map<Character, List<Integer>> map) {
        map.clear();
        for (char c : possible) {
            map.put(c, new ArrayList<>());
        }
    }
}
