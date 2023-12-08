package easy.tree;

import easy.tree.nodes.TreeNode;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        return tree(root);
    }

    public String tree(TreeNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);

        if (node.left != null || node.right != null) {
            sb.append("(")
                    .append(tree(node.left))
                    .append(")");
        }

        if (node.right != null) {
            sb.append("(")
                    .append(tree(node.right))
                    .append(")");
        }

        return sb.toString();
    }
}
