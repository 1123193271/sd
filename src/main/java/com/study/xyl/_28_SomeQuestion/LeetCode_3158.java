package com.study.xyl._28_SomeQuestion;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_3158 {
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                ans ^= num;
            } else {
                set.add(num);
            }
        }
        return ans;
    }
}
