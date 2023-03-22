package medium.linked;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-list/
 * Runtime 36.20% Memory 58.41%
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.sort(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < list.size(); i++) {
            if(i!= list.size()-1){
                list.get(i).next = list.get(i+1);
            }else{
                list.get(i).next = null;
            }
        }

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
