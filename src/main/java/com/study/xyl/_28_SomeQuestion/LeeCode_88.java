package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 16:06
 */
public class LeeCode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (j < 0) {
                nums1[k] =  nums1[i];
                i--;
                k--;
                continue;
            } else if (i < 0){
                nums1[k] = nums2[j];
                j--;
                k--;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                nums1[k] =  nums1[i];
                i--;
            } else {
                 nums1[k] = nums2[j];
                 j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        LeeCode_88 leeCode88 = new LeeCode_88();

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        leeCode88.merge(nums1,0, nums2, 1);


    }
}
