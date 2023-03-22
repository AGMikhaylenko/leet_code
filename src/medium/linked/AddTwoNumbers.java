package medium.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * Runtime 32.19% Memory 50.27%
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> stack1 = new ArrayList<>();
        List<ListNode> stack2 = new ArrayList<>();

        while (l1 != null) {
            if (stack1.size() > 0) {
                stack1.add(0, l1);
            } else {
                stack1.add(l1);
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            if (stack2.size() > 0) {
                stack2.add(0, l2);
            } else {
                stack2.add(l2);
            }
            l2 = l2.next;
        }

        byte added = 0;
        byte v1, v2, res;
        ListNode prev = null;
        ListNode first = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || added != 0) {
            v1 = stack1.isEmpty() ? 0 : (byte) stack1.remove(stack1.size() - 1).val;
            v2 = stack2.isEmpty() ? 0 : (byte) stack2.remove(stack2.size() - 1).val;

            res = (byte) (v1 + v2 + added);
            added = (byte) (res / 10);
            res = (byte) (res % 10);

            if (first == null) {
                prev = new ListNode(res);
                first = prev;

            } else {
                ListNode node = new ListNode(res);
                prev.next = node;
                prev = node;
            }
        }

        return first == null ? new ListNode(0) : first;
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
