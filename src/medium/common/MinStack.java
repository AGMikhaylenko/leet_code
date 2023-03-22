package medium.common;

/**
 * https://leetcode.com/problems/min-stack/
 * Runtime 100% Memory 64.73%
 */
public class MinStack {

    MyNode top;

    public MinStack() {

    }

    public void push(int val) {
        MyNode node = new MyNode(val);
        node.next = top;

        if (top == null || node.val < top.min.val) {
            node.min = node;
        } else {
            node.min = top.min;
        }

        top = node;
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min.val;
    }

    class MyNode {
        int val;
        MyNode next;
        MyNode min;

        public MyNode(int val) {
            this.val = val;
        }
    }
}
