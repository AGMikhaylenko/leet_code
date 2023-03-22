package medium.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Runtime 24.26% Memory 51.64%
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if (list.size() != n) {
            if (n != 1) {
                list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
            } else {
                list.get(list.size() - n - 1).next = null;
            }
        }
        list.remove(list.size() - n);
        return list.isEmpty() ? null : list.get(0);
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
