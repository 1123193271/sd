package com.study.xyl._28_SomeQuestion_2;

/**
 * @author 11231
 * @date 2024/9/24 11:46
 */
public class LeeCode_704 {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (start == end) {
                return -1;
            } else if (nums[mid] > target) {
                return binarySearch(nums, start, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, end, target);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LeeCode_704 leeCode704 = new LeeCode_704();
        leeCode704.search(new int[]{2,5}, 0);
    }
}
