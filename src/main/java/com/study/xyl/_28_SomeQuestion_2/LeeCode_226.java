package com.study.xyl._28_SomeQuestion_2;

/**
 * @author 11231
 * @date 2024/9/23 18:37
 */
public class LeeCode_226 {

    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }

    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
    }

    public static void main(String[] args) {

    }
}
