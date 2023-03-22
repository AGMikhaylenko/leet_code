package medium.linked;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * Runtime 100% Memory 88.59%
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        boolean isOdd = true;

        ListNode current = head;
        ListNode currentOdd = null;
        ListNode currentEven = null;
        ListNode firstEven = null;

        while (current != null) {
            if (isOdd) {
                if (currentOdd != null) {
                    currentOdd.next = current;
                }
                currentOdd = current;
            } else {
                if (firstEven == null) {
                    firstEven = current;
                }
                if (currentEven != null) {
                    currentEven.next = current;
                }
                currentEven = current;
            }
            current = current.next;
            isOdd = !isOdd;
        }

        if (firstEven != null) {
            currentOdd.next = firstEven;
            currentEven.next = null;
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
