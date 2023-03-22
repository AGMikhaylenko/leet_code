package medium.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Runtime 87.53% Memory 69.74%
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNodeExtra> queue = new ArrayList<>();
        queue.add(new TreeNodeExtra(root, 0));
        List<List<Integer>> valuesByLevels = new ArrayList<>();

        TreeNodeExtra currentExtra;
        while (!queue.isEmpty()) {
            currentExtra = queue.remove(0);
            if(currentExtra.node==null){
                continue;
            }

            if (valuesByLevels.size() < currentExtra.level + 1) {
                valuesByLevels.add(new ArrayList<>());
            }
            valuesByLevels.get(currentExtra.level).add(currentExtra.node.val);

            if (currentExtra.node.left != null) {
                queue.add(new TreeNodeExtra(currentExtra.node.left, currentExtra.level + 1));
            }

            if (currentExtra.node.right != null) {
                queue.add(new TreeNodeExtra(currentExtra.node.right, currentExtra.level + 1));
            }
        }

        for (int i = 1; i < valuesByLevels.size(); i+=2) {
            Collections.reverse(valuesByLevels.get(i));
        }

        return valuesByLevels;
    }

    class TreeNodeExtra {
        int level;
        TreeNode node;

        public TreeNodeExtra(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
