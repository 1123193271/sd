package com.study.xyl._28_SomeQuestion_3;

/**
 * @author 11231
 * @date 2024/9/24 16:53
 */
public class MergeSort {

    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        partition(nums, 0, nums.length - 1);
        return nums;
    }

    public void partition(int[] nums, int left, int right){
        if (left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;
        partition(nums, left, mid);
        partition(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    public void merge(int[] nums, int left , int right, int mid){
        int i = left, j = mid + 1;
        int length = right - left + 1;
        int[] array = new int[length];
        for (int k = 0; k < length; k++) {
            if (i <= mid && j <= right) {
                if ( nums[i] < nums[j]) {
                    array[k] = nums[i];
                    i++;
                } else {
                    array[k] = nums[j];
                    j++;
                }
            } else {
                if (i > mid) {
                    array[k] = nums[j];
                    j++;
                } else {
                    array[k] = nums[i];
                    i++;
                }
            }
        }
        System.arraycopy(array, 0, nums, left, length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,6,1,2,4,76,8,3,22};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums);
    }
}
