package easy.operation_with_numbers;

/**
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 * Runtime 100% Memory 96.92%
 */
public class CountOddNumbersInAnIntervalRange {

    public static void main(String[] args) {

    }

    public int countOdds(int low, int high) {
        if (low % 2 != 0 || high % 2 != 0) {
            high++;
        }
        return high - low - (high - low) / 2;
    }
}
