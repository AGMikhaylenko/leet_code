package easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Runtime 100% Memory 48.41%
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        TreeNode current;
        TreeNode buf;

        while (!queue.isEmpty()) {
            current = queue.remove(0);

            if (current != null) {
                buf = current.left;
                current.left = current.right;
                current.right = buf;

                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return root;
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
