package com.study.xyl._27_leecCode;

import java.util.Arrays;

/**
 * @author 11231
 * @date 2024/9/13 12:00
 */
public class Q_2398 {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int len = chargeTimes.length;
        int[][] robots = new int[len][2];
        for (int i = 0; i < len; i++) {
            robots[i] =new int[]{chargeTimes[i],runningCosts[i]};
        }
        long[] dp = new long[len];
        int res = 0;

        for (int i = 0; i < len; i++) {
            dp[i] = 0x7fffffffffffffffL;
            for (int j = 0; j < len - i; j++) {
                int max = robots[j][0];
                long ret = 0L;
                for (int k = j; k < j+i; k++) {
                    max = Math.max(robots[k][0], max);
                    ret += (long) i *robots[k][1];
                }
                dp[i] = Math.min(dp[i], ret + max);
            }
            if (dp[i] <= budget) {
                res = i;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q_2398 q2398 = new Q_2398();
        int[] chargeTimes = new int[]{8,76,74,9,75,71,71,42,15,58,88,38,56,59,10,11};
        int[] runningCosts = new int[]{1,92,41,63,22,37,37,8,68,97,39,59,45,50,29,37};
        long budget = 412L;

        System.out.println(q2398.maximumRobots(chargeTimes, runningCosts, budget));
    }
}
