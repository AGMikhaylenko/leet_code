package easy.common;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Runtime 99.17% Memory 95.82%
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        List<Character> stack = new ArrayList<>(4);
        char last;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                last = stack.remove(stack.size() - 1);
                if (c == ']' && last != '['
                        || c == ')' && last != '('
                        || c == '}' && last != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
