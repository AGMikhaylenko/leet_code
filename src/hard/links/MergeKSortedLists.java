package hard.links;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Runtime 5.2% Memory 87.31%
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode firstNode = null;

        ListNode current = null;
        short minIndex;
        while (true){
            minIndex = -1;

            for (short i = 0; i < lists.length; i++) {
                if (lists[i] != null && (minIndex == -1 || lists[minIndex].val > lists[i].val)) {
                    minIndex = i;
                }
            }

            if(minIndex == -1){
                break;
            }

            if (firstNode == null) {
                firstNode = lists[minIndex];
            }else{
                current.next = lists[minIndex];
            }

            current = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
        }

        return firstNode;
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
