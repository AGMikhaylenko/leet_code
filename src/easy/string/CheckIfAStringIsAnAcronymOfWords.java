package easy.string;

import java.util.List;

/**
 * https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words
 * Runtime 100% Memory 83.85%
 */
public class CheckIfAStringIsAnAcronymOfWords {

    public boolean isAcronym(List<String> words, String s) {
        char[] symbols = s.toCharArray();
        if (symbols.length != words.size()) {
            return false;
        }

        for (int i = 0; i < words.size(); i++) {
            if (symbols[i] != words.get(i).charAt(0)) {
                return false;
            }
        }

        return true;
    }
}
