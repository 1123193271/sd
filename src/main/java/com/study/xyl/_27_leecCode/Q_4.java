package com.study.xyl._27_leecCode;

/**
 * @author 11231
 * @date 2024/9/10 19:51
 */
public class Q_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0,j = 0,k = 0, length1 = nums1.length, length2 = nums2.length;
        int length = (length1+length2)/2 + 1;
        int[] temp =new int[length];
        while ((i < length1 || j < length2) && k < length) {
            if (i == length1) {
                temp[k] = nums2[j];
                j++;
                k++;
                continue;
            }
            if (j == length2) {
                temp[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else if (nums1[i] >= nums2[j]) {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        return (length1+length2)%2 > 0 ? temp[length - 1] :
                (temp[length - 1] + temp[length - 2]) / 2.0;
    }
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{},new int[]{2,2,2,4,4});
    }
}
