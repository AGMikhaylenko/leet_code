package easy.string;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * Runtime 85.80% Memory 76.82%
 */
public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        char[] symbols = s.toCharArray();

        for (int i = symbols.length - 1; i >= 0; i--) {
            if (symbols[i] == '#') {
                sb.append((char) (96 + charToInt(symbols[i - 2]) * 10 + charToInt(symbols[i - 1])));
                i -= 2;
            } else {
                sb.append((char) (96 + charToInt(symbols[i])));
            }
        }

        return sb.reverse().toString();
    }

    private int charToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }


}
