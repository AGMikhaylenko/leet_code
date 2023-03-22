package easy.binary;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * Runtime 100% Memory 93.50%
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        ListNode first = head;
        int res = 0;
        short count = 0;
        while (first != null) {
            count++;
            first = first.next;
        }

        count--;
        while (head != null) {
            res += head.val * Math.pow(2, count--);
            head = head.next;
        }

        return res;
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
