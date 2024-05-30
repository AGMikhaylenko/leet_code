package easy.tree;

import easy.tree.nodes.TreeNode;

public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        return switch (root.val) {
            case 0 -> false;
            case 1 -> true;
            case 2 -> evaluateTree(root.left) || evaluateTree(root.right);
            case 3 -> evaluateTree(root.left) && evaluateTree(root.right);
            default -> false;
        };
    }
}
