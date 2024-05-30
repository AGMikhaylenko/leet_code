package medium.linked;

import medium.linked.nodes.ListNode;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {
        ListNode savedHead = head;
        int n = 0;

        while (head != null) {
            head = head.next;
            n++;
        }

        if (n == 1) {
            return null;
        }

        n /= 2;

        head = savedHead;
        while (n > 0) {
            if (n == 1) {
                head.next = head.next.next;
            }
            head = head.next;
            n--;
        }

        return savedHead;
    }
}
