package com.study.xyl._28_SomeQuestion_3;

/**
 * @author 11231
 * @date 2024/9/24 12:20
 */
public class SelectSort {

    public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(new int[]{3,4,1,2,4,6,8,9,3});
    }
}
