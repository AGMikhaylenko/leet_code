package easy.common;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * Runtime 100% Memory 76.23%
 */
public class ImplementQueueUsingStacks {

    class MyQueue {

        Stack<Integer> stack;
        Stack<Integer> buf;

        public MyQueue() {
            stack = new Stack<>();
            buf = new Stack<>();
        }

        public void push(int x) {
            fillStackFromStack(stack, buf);
            buf.push(x);
            fillStackFromStack(buf, stack);
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }

        private void fillStackFromStack(Stack<Integer> stackFirst, Stack<Integer> stackSecond) {
            stackSecond.clear();
            while (!stackFirst.isEmpty()) {
                stackSecond.push(stackFirst.pop());
            }
        }
    }
}
