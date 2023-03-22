package medium.linked;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reorder-list/
 * Runtime 16.73% Memory 23.93%
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        int count = stack.size();
        int size = count;

        current = head;
        ListNode currentFromStack;
        while (count > 1) {
            currentFromStack = stack.pop();
            currentFromStack.next = current.next;
            current.next = currentFromStack;
            current = currentFromStack.next;
            count -= 2;
        }

        count = 0;
        current = head;
        while (current != null) {
            count++;
            if (count == size) {
                current.next = null;
            }
            current = current.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
