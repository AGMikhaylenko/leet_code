package medium.linked;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Runtime 100% Memory 41.70%
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        int size = 0;
        while (prev != null) {
            size++;
            prev = prev.next;
        }

        n = size - n;
        if (n == 0) {
            return head.next;
        }

        prev = head;
        while (n > 0) {
            n--;
            if (n != 0) {
                prev = prev.next;
            } else {
                prev.next = prev.next.next;
            }
        }

        return head;
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
