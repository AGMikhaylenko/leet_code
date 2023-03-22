package easy.string;

/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 * Runtime 72.95% Memory 84.83%
 */
public class FindFirstPalindromicStringInTheArray {

    public String firstPalindrome(String[] words) {
        boolean isGood;
        for (String word : words) {
            isGood = true;
            for (int j = 0; j < word.length() / 2; j++) {
                if (word.charAt(j) != word.charAt(word.length() - 1 - j)) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                return word;
            }
        }
        return "";
    }
}
