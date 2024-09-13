package com.study.xyl._27_leecCode;

import java.util.Arrays;

/**
 * @author 11231
 * @date 2024/9/12 19:54
 */
public class Q_17_08 {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i)
            person[i] = new int[]{height[i], weight[i]};
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0)
                i = -(i + 1);
            dp[i] = pair[1];
            if (i == res)
                ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        Q_17_08 q1708 = new Q_17_08();
        System.out.println(q1708.bestSeqAtIndex(new int[]{1, 2, 2, 3, 4}, new int[]{4, 1, 2, 5, 7}));
    }
}
