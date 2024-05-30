package easy.tree;

import easy.tree.nodes.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * Runtime 17.30% Memory 5.76%
 */
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }

            if (node.right != null && node.val <= high) {
                stack.push(node.right);
            }

            if (node.left != null && node.val >= low) {
                stack.push(node.left);
            }
        }

        return sum;

    }
}
