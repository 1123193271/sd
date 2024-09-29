package com.study.xyl._28_SomeQuestion_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11231
 * @date 2024/9/23 17:27
 */
public class LeeCode_94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    public void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);

    }

    public static void main(String[] args) {

    }
}
