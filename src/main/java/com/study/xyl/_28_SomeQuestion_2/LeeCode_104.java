package com.study.xyl._28_SomeQuestion_2;

/**
 * @author 11231
 * @date 2024/9/23 18:08
 */
public class LeeCode_104 {

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
