package easy.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Easy
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        Set<TreeNode> checkedNotes = new HashSet<>();

        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        TreeNode current;

        while (!stack.isEmpty()) {
            current = stack.get(stack.size() - 1);

            if (current.left != null && !checkedNotes.contains(current.left)) {
                stack.add(current.left);
                checkedNotes.add(current.left);
            } else {
                values.add(current.val);
                stack.remove(current);
                if (current.right != null) {
                    stack.add(current.right);
                }
            }
        }

        return values;
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
