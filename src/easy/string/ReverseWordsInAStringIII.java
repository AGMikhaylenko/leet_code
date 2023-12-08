package easy.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Runtime 58.90% Memory 43.95%
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        char buf;
        for (String w : words) {
            char[] symbols = w.toCharArray();
            for (int i = 0; i < symbols.length / 2; i++) {
                buf = symbols[i];
                symbols[i] = symbols[symbols.length - 1 - i];
                symbols[symbols.length - 1 - i] = buf;
            }
            sb.append(symbols);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
