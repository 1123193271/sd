package com.study.xyl._28_SomeQuestion_3;

/**
 * @author 11231
 * @date 2024/9/24 12:32
 */
public class InsertSort {

    public int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //from the second
            int j = i - 1;
            int temp = nums[i];
            while (j >= 0) {
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(new int[]{3});
    }
}
