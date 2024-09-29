package com.study.xyl._28_SomeQuestion_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11231
 * @date 2024/9/23 17:41
 */
public class LeeCode_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    public static void main(String[] args) {

    }
}
