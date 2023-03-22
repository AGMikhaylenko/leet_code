package medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 *  Runtime 27.37% Memory 28.63%
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {

    public static void main(String[] args) {
        String[] words = {"cc", "ll", "xx"};
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(words));
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int res = 0;

        for (String s : words) {
            sb.setLength(0);
            sb.append(s).reverse();

            if (wordsMap.containsKey(sb.toString()) && wordsMap.get(sb.toString()) > 0) {
                res += 4;
                wordsMap.merge(sb.toString(), -1, Integer::sum);
            } else {
                if (wordsMap.containsKey(s)) {
                    wordsMap.merge(s, 1, Integer::sum);
                } else {
                    wordsMap.put(s, 1);
                }
            }
        }

        if (wordsMap.entrySet()
                .stream()
                .anyMatch(e -> e.getValue() == 1 && e.getKey().charAt(0) == e.getKey().charAt(1))) {
            res += 2;
        }

        return res;
    }

}
