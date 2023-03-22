package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * Runtime 74.69% Memory 64.38%
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res = new PascalsTriangle().generate(n);

        for(List<Integer> row: res){
            System.out.println(row);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> prevLine = new ArrayList<>();
        prevLine.add(1);
        res.add(prevLine);

        while (--numRows > 0) {
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
            res.add(row);
            prevLine = row;
        }

        return res;
    }
}
