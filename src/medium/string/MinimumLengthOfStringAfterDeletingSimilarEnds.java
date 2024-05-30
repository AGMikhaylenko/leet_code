package medium.string;

/**
 * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 * Runtime 80.63% Memory 53.65%
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public int minimumLength(String s) {

        char[] symbols = s.toCharArray();
        int left = 0;
        int right = symbols.length - 1;

        while (left < right) {
            if (symbols[left] != symbols[right]) {
                break;
            }

            while (left < right && symbols[left] == symbols[right]) {
                left++;
            }
            left--;

            while (left < right && symbols[left] == symbols[right]) {
                right--;
            }
            left++;
        }

        return Math.max(0, right - left + 1);
    }
}
