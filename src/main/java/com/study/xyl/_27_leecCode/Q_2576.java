package com.study.xyl._27_leecCode;

import java.util.Arrays;

/**
 * @author 11231
 * @date 2024/9/12 13:29
 */
public class Q_2576 {
    public static int maxNumOfMarkedIndices(int[] nums) {
        mergeSort(nums);
        int ret = nums.length/2;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < ret; i++) {
                if (2 * nums[i] > nums[nums.length - ret + i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                ret--;
            }
        }
        return ret*2;
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length  < 2) {
            return;
        }
        int length = nums.length;
        process(nums, 0, length - 1);
    }

    public static void process(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        process(array, left, mid);
        process(array, mid + 1, right);
        partition(array, left, mid, right);
    }

    public static void partition(int[] array, int left, int mid, int right) {
        int i=left;
        int j=mid+1;
        int index = 0;
        int[] help = new int[right - left + 1];
        while (i <= mid && j <= right) {
            help[index++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            help[index++] = array[i++];
        }
        while (j <= right) {
            help[index++] = array[j++];
        }
        System.arraycopy(help, 0, array, left, help.length);

    }

    public static void main(String[] args) {
        System.out.println(maxNumOfMarkedIndices(new int[]{1,78,27,48,14,86,79,68,77,20,57,21,18,67,5,51,70,85,47,56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78,39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10}));
    }
}
