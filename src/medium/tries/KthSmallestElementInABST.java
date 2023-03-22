package medium.tries;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Runtime 5.52% Memory 13.70%
 */
public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> values = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root != null) {
                values.add(root.val);
                stack.push(root.left);
                stack.push(root.right);
            }
        }

        return values.stream()
                .sorted()
                .skip(k)
                .findFirst()
                .get();
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
