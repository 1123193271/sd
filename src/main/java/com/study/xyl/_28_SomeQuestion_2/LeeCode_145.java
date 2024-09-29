package com.study.xyl._28_SomeQuestion_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11231
 * @date 2024/9/23 17:41
 */
public class LeeCode_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);
    }

    public static void main(String[] args) {

    }
}
