package com.study.xyl._26_algorithm;

/**
 * @author 11231
 * @date 2024/9/9 14:09
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode exampleBinaryTree() {
        TreeNode node1 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(6, null, null);
        TreeNode node3 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, node1);
        TreeNode node5 = new TreeNode(3, node2, node1);
        TreeNode node6 = new TreeNode(2, node4, node3);
        TreeNode node7 = new TreeNode(1, node6, node5);

        return node7;
    }

}
