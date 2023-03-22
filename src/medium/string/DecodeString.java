package medium.string;

import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/decode-string
 */
public class DecodeString {

    List<Character> digits = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(new DecodeString().decodeString(s));
    }

    public String decodeString(String s) {
        char[] symbols = s.toCharArray();

        StringBuilder sbRes = new StringBuilder();
        StringBuilder sbBuf = new StringBuilder();
        byte openBrackets = 0;

        int count = 0;

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == '[') {
                if (++openBrackets != 1) {
                    sbBuf.append('[');
                }
                continue;
            }

            if (symbols[i] == ']') {
                if (--openBrackets == 0) {
                    sbRes.append(
                            multiplyString(
                                    decodeString(sbBuf.toString()),
                                    count
                            )
                    );
                    sbBuf.delete(0, sbBuf.length());
                } else {
                    sbBuf.append(']');
                }
                continue;
            }

            if (openBrackets > 0) {
                sbBuf.append(symbols[i]);
                continue;
            }

            if (digits.contains(symbols[i])) {
                sbBuf.append(symbols[i]);
                while (true) {
                    if (digits.contains(symbols[i + 1])) {
                        sbBuf.append(symbols[i + 1]);
                        i++;
                    } else {
                        count = Integer.valueOf(sbBuf.toString());
                        sbBuf.delete(0, sbBuf.length());
                        break;
                    }
                }
                continue;
            }

            sbRes.append(symbols[i]);
        }

        return sbRes.toString();
    }


    private String multiplyString(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
