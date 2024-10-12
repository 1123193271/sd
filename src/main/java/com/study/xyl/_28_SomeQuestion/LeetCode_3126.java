package com.study.xyl._28_SomeQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode_3126 {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                if (i % (j*k) == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public long numberOfPairs2(int[] nums1, int[] nums2, int k) {
        if (nums1.length <= 1000 && nums2.length <= 1000) {
            int ans = 0;
            for (int i : nums1) {
                for (int j : nums2) {
                    if (i % (j*k) == 0) {
                        ans++;
                    }
                }
            }
            return ans;
        }
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        int max = 0;
        for (int i : nums1) {
            max = Math.max(i, max);
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            count2.put(i, count2.getOrDefault(i, 0) + 1);
        }
        long res = 0;
        for (Integer i : count2.keySet()) {
            for (int j = i * k; j <= max; j += i * k) {
                if (count.containsKey(j)) {
                    res += (long) count.get(j) * count2.get(i);
                }
            }
        }
        return res;
    }
}
