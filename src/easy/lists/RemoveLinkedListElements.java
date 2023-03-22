package easy.lists;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * Runtime 92.59% Memory 5.84%
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode prev = null;
        head = null;

        while (current != null) {
            if (current.val == val) {
                if (prev != null) {
                    prev.next = current.next;
                }
            } else {
                prev = current;
                if (head == null) {
                    head = current;
                }
            }
            current = current.next;
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
