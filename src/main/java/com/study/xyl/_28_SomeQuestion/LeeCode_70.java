package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 15:44
 */
public class LeeCode_70 {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else if (i == 1) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

    }
}
