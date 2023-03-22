package medium.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * Runtime 7.96% Memory 15.17%
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        List<ExtraNode> queue = new ArrayList<>();
        queue.add(new ExtraNode(root, 0));
        ExtraNode current;
        while (!queue.isEmpty()) {
            current = queue.remove(0);

            if (res.size() <= current.level) {
                List<Integer> level = new ArrayList<>();
                level.add(current.node.val);
                res.add(level);
            } else {
                res.get(current.level).add(current.node.val);
            }

            for (Node child : current.node.children) {
                if (child != null) {
                    queue.add(new ExtraNode(child, current.level + 1));
                }
            }
        }

        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class ExtraNode {
        Node node;
        int level;

        public ExtraNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
