package com.study.xyl._28_SomeQuestion;

public class LeetCode_746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        for (int i = 0; i < minCost.length; i++) {
            if (i <= 1) {
                minCost[i] = 0;
            } else {
                minCost[i] = Math.min(minCost[i - 1] + cost[i-1], minCost[i - 2] + cost[i - 2]);
            }
        }
        return Math.min(minCost[cost.length - 1] + cost[cost.length - 1],
                minCost[cost.length - 2] + cost[cost.length - 2]);
    }


}
