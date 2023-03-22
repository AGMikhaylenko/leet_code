package easy.array;

/**
 * https://leetcode.com/problems/reverse-string/
 * Runtime 97.99% Memory 25%
 */
public class ReverseString {

    public void reverseString(char[] s) {
        char buf;

        for (int i = 0; i < s.length / 2; i++) {
            buf = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = buf;
        }
    }
}
