package com.study.xyl._28_SomeQuestion_2;

/**
 * @author 11231
 * @date 2024/9/26 9:52
 */
public class LeeCode_2535 {

    public int differenceOfSum(int[] nums) {
        int allNums = 0;
        int allDigital = 0;
        for (int num : nums) {
            allNums += num;
            int digital = 0;
            int temp = num;
            while (temp >= 10) {
                digital += (temp % 10);
                temp /= 10;
            }
            digital += temp;
            allDigital += digital;
        }
        return allNums > allDigital ? allNums - allDigital : allDigital - allNums;
    }

    public static void main(String[] args) {
        LeeCode_2535 leeCode2535 = new LeeCode_2535();
        int i = leeCode2535.differenceOfSum(new int[]{2,7,8,10,8,10,1,10,5,9});
        System.out.println(i);

    }
}
