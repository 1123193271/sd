package com.study.xyl._26_algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 11231
 * @date 2024/9/9 16:01
 */
public class MinDepth {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            //将当前队列所有节点向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                assert cur != null;
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.exampleBinaryTree();
        System.out.println(minDepth(root));
    }
}
