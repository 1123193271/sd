package com.study.xyl._28_SomeQuestion_2;

/**
 * @author 11231
 * @date 2024/9/23 18:15
 */
public class LeeCode_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.right) - maxDepth(root.left)) <= 1;
    }

    public int maxDepth(TreeNode root) {
        if (root ==  null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
