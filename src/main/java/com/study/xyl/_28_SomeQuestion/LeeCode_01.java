package com.study.xyl._28_SomeQuestion;

import java.util.HashMap;

/**
 * @author 11231
 * @date 2024/9/13 15:53
 */
public class LeeCode_01 {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null && map.get(target - nums[i]) != i) {
                //找到了
                ret[0] = i;
                ret[1] = map.get(target - nums[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
