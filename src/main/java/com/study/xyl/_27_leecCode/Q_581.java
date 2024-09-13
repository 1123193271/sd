package com.study.xyl._27_leecCode;


import java.util.Arrays;
import java.util.Stack;

/**
 * @author 11231
 * @date 2024/9/12 16:38
 */
public class Q_581 {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int start = -1;
        int end = -2;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                start = Math.min(stack.pop(), start == -1 ? i : start);
            }
            stack.push(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && nums[i] > nums[stack2.peek()]) {
                end = Math.max(stack2.pop(), end == -2 ? i : end);
            }
            stack2.push(i);
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2,1}));
    }
}
