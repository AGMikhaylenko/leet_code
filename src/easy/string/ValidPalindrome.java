package easy.string;

import java.util.Objects;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * Runtime  Memory
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] symbols = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] >= 97 && 122 >= symbols[i] || symbols[i] >= 48 && 57 >= symbols[i]) {
                sb.append(symbols[i]);
            }
        }

        String rev = sb.toString();
        return Objects.equals(sb.reverse().toString(), rev);
    }
}
