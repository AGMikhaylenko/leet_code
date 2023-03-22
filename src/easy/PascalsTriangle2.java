package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * Runtime 84.50% Memory 49.52%
 */
public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevLine = new ArrayList<>();
        prevLine.add(1);

        while (--rowIndex >= 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < prevLine.size(); i++) {
                if (i == 0) {
                    row.add(prevLine.get(i));
                }
                if (i == prevLine.size() - 1) {
                    row.add(prevLine.get(i));
                } else {
                    row.add(prevLine.get(i) + prevLine.get(i + 1));
                }
            }
            prevLine = row;
        }

        return prevLine;
    }
}
