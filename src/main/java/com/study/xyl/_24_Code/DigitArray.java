package com.study.xyl._24_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不包含重读数字的数组，返回全排列
 * nums=[1,3,5,7,9]
 */
public class DigitArray {
    public static List<List<Integer>> permute(int[] numb) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), numb);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] numb) {
        if (tempList.size() == numb.length) {
            //找到满足条件的一组
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < numb.length; i++) {
            //因为不能有重复的，所以有重复的不能选择
            if (tempList.contains(numb[i])) {
                continue;
            }
            //不是重复的就选择当前值加入
            tempList.add(numb[i]);
            //递归
            backtrack(list, tempList, numb);
            //撤销选择
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] numb = {1,3,5,7,9};
        List<List<Integer>> permute = permute(numb);
        permute.forEach(item -> {
            System.out.println(item.toString());
        });

    }
}
