package medium.linked;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Runtime 100% Memory 21.16%
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next!=null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
