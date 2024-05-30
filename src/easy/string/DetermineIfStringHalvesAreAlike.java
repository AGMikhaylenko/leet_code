package easy.string;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 * Runtime 42.07% Memory 28.59%
 */
public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] symbols = s.toCharArray();

        int res = 0;
        for (int i = 0; i < symbols.length / 2; i++) {
            if (vowels.contains(symbols[i])) {
                res++;
            }
            if (vowels.contains(symbols[symbols.length - i - 1])) {
                res--;
            }
        }

        return res == 0;
    }
}
