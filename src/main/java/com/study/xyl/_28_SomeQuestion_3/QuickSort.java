package com.study.xyl._28_SomeQuestion_3;

/**
 * @author 11231
 * @date 2024/9/25 9:11
 */
public class QuickSort {

    public int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[end];
        int i = start;
        int j = end;
        boolean flag = true;
        while (i < j) {
            if (flag) {
                if (nums[i] > pivot) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                    flag = false;
                } else {
                    i++;
                }
            } else {
                if (nums[j] <= pivot) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                    flag = true;
                } else {
                    j--;
                }
            }

        }
        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(new int[]{3,4,6,1,2,4,76,8,3,22});
    }
}
