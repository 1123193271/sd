package com.study.xyl._28_SomeQuestion;

public class LeetCode_198 {
    public int rob(int[] nums) {
        int[] robMoney = new int[nums.length];
        for (int i = 0; i < robMoney.length; i++) {
            if (i == 0) {
                robMoney[i] = nums[i];
            } else if (i == 1) {
                robMoney[i] = Math.max(nums[0], nums[1]);
            } else {
                robMoney[i] = Math.max(robMoney[i - 2] + nums[i], robMoney[i - 1]);
            }
        }
        return robMoney[nums.length - 1];
    }
}
