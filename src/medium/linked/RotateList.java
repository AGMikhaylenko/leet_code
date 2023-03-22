package medium.linked;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/rotate-list/
 * Runtime 23.96% Memory 27.24%
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        if (list.size() < 2) {
            return head;
        }

        k %= list.size();

        while (k > 0) {
            current = list.remove(list.size() - 1);
            list.get(list.size() - 1).next = null;
            list.add(0, current);
            list.get(0).next = list.get(1);
            k--;
        }

        return list.get(0);
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
