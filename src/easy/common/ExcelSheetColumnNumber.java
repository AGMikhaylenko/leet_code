package easy.common;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * Runtime 100% Memory 29.52%
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        char[] c = columnTitle.toCharArray();

        int res = 0;
        for (int i = 0; i < c.length; i++) {
            res += (c[c.length - i - 1] - 64) * Math.pow(26, i);
        }
        return res;
    }
}
