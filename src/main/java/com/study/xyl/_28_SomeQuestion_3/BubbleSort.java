package com.study.xyl._28_SomeQuestion_3;

import java.util.Arrays;

/**
 * @author 11231
 * @date 2024/9/24 16:14
 */
public class BubbleSort {

    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        return nums;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(new int[]{3, 4, 1, 2, 4, 6, 8, 9, 3})));
    }
}
