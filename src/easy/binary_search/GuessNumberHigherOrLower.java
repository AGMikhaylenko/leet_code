package easy.binary_search;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * Runtime 100% Memory 21.45%
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int res;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            res = guess(mid);
            if (res == 0) {
                return mid;
            }
            if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int guess(int num) {
        return num;
    }
}
