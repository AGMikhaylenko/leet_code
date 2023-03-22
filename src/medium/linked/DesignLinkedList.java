package medium.linked;

/**
 * https://leetcode.com/problems/design-linked-list/
 * Runtime 12,82% Memory 32.65%
 */
public class DesignLinkedList {

    public static void main(String[] args) {
        DesignLinkedList solution = new DesignLinkedList();
        solution.addAtHead(1);
        solution.addAtTail(3);
        solution.addAtIndex(1, 2);
        solution.get(1);
        solution.deleteAtIndex(1);
        solution.get(1);
    }

    Node head;
    int count = 0;

    public DesignLinkedList() {

    }

    public int get(int index) {
        if (index >= count) {
            return -1;
        }
        return getNodeByIndex(index).val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val, head);
        head = node;
        count++;
    }

    public void addAtTail(int val) {
        Node lastNode = getNodeByIndex(count - 1);
        Node node = new Node(val, null);
        if (lastNode == null) {
            head = node;
        } else {
            lastNode.next = node;
        }
        count++;
    }

    public void addAtIndex(int index, int val) {
        Node lastNode = getNodeByIndex(index);
        if (lastNode != null || index == count) {
            Node node = new Node(val, lastNode);
            if (index == 0) {
                head = node;
            } else {
                lastNode = getNodeByIndex(index - 1);
                lastNode.next = node;
            }
            count++;
        }
    }

    public void deleteAtIndex(int index) {
        Node lastNode = getNodeByIndex(index);
        if (lastNode != null) {
            if (index == 0) {
                head = lastNode.next;
            } else {
                Node prev = getNodeByIndex(index - 1);
                prev.next = lastNode.next;
            }
            count--;
        }
    }

    private Node getNodeByIndex(int index) {
        int i = 0;
        Node node = head;
        while (node != null) {
            if (i == index) {
                return node;
            } else {
                node = node.next;
                i++;
            }
        }
        return null;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
