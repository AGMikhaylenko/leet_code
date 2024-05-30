package medium.string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/
 */
public class RemovingStarsFromAString {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }


        Stack<Character> reverseStack = new Stack<>();
        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!reverseStack.isEmpty()){
            sb.append(reverseStack.pop());
        }

        return sb.toString();
    }
}
