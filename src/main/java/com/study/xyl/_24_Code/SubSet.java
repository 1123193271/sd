package com.study.xyl._24_Code;

import org.hibernate.type.IntegerType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 整数数组。数组中的元素互不相同
 * 返回该数组所有可能的子集
 */
public class SubSet {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int total = 1 << nums.length;
        for (int i = 0; i < total; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //如果数字i的某一位上是1就选择
                if ((i & (1 << j)) != 0) {
                    subList.add(nums[j]);
                }
            }
            ans.add(subList);
        }
        return ans;
    }
}
