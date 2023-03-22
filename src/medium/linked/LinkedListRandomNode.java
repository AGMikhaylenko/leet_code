package medium.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 * Runtime 48.76% Memory 16.6%
 */
public class LinkedListRandomNode {

    private List<Integer> values = new ArrayList<>();

    public LinkedListRandomNode(ListNode head) {
        while(head!=null){
            values.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int index = (int) (Math.random() * values.size());
        return values.get(index);
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
