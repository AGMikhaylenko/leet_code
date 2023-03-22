package easy.string;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * Runtime 90.69% Memory 68.47%
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                String b = s.substring(0, n / i);
                if (b.repeat(i).equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}
