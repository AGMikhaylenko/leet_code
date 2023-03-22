package medium.linked;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * Runtime 25.91% Memory 22.69%
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = prepareValues(l1);
        Stack<Integer> s2 = prepareValues(l2);

        int added = 0;
        int val = 0;
        ListNode next = null;
        ListNode current = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            val = added + (!s1.isEmpty() ? s1.pop() : 0) + (!s2.isEmpty() ? s2.pop() : 0);
            added = val / 10;
            val %= 10;
            current = new ListNode(val, next);
            next = current;
        }

        if (added != 0) {
            current = new ListNode(added, next);
        }

        return current;
    }

    private Stack<Integer> prepareValues(ListNode node) {
        Stack<Integer> values = new Stack<>();
        while (node != null) {
            values.add(node.val);
            node = node.next;
        }
        return values;
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
