package easy.lists;

import medium.linked.nodes.ListNode;


/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Runtime 100% Memory 14.78%
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }

        size /= 2;
        current = head;
        while (size >= 0) {
            if (size == 0) {
                return current;
            }

            current = current.next;
            size--;
        }

        return head;
    }
}
