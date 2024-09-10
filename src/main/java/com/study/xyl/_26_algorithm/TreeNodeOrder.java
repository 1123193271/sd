package com.study.xyl._26_algorithm;

import java.util.Stack;

/**
 * @author 11231
 * @date 2024/9/9 14:17
 */
public class TreeNodeOrder {

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public static void inOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.exampleBinaryTree();

        //先序遍历
        preOrder(root);
        //中序遍历

        //后序遍历
    }


}
