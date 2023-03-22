package medium.common;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Runtime 31.11% Memory 26.32%
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")
                    || s.equals("-")
                    || s.equals("*")
                    || s.equals("/")) {
                Integer i2 = stack.pop();
                Integer i1 = stack.pop();

                switch (s) {
                    case "+" -> i1 += i2;
                    case "-" -> i1 -= i2;
                    case "*" -> i1 *= i2;
                    case "/" -> i1 /= i2;
                }
                stack.push(i1);

            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }
}
