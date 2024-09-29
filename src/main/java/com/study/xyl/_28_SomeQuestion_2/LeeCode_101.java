package com.study.xyl._28_SomeQuestion_2;

/**
 * @author 11231
 * @date 2024/9/23 17:52
 */
public class LeeCode_101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {

    }
}
