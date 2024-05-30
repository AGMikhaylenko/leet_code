package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber != 0) {
            if (columnNumber % 26 != 0) {
                sb.append((char) (64 + columnNumber % 26));
            } else {
                sb.append((char) (64 + 26));
                columnNumber -= 26;
            }
            columnNumber /= 26;
        }

        return sb.reverse().toString().toUpperCase();
    }
}
