package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 16:10
 */
public class LeeCode_283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
            else {
                nums[i-count] = nums[i];
                nums[i] = count == 0 ? nums[i] : 0;
            }
        }
    }

    public static void main(String[] args) {
        LeeCode_283 leeCode283 = new LeeCode_283();
        int[] nums = new int[]{0,1,0,3,12};
        leeCode283.moveZeroes(nums);
        System.out.println(nums);
    }
}
