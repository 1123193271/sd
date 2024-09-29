package com.study.xyl._28_SomeQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11231
 * @date 2024/9/13 16:25
 */
public class LeeCode_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] number = new int[nums.length];
        for (int num : nums) {
            number[num-1] = 1;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            if (number[i] == 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeeCode_448 leeCode448 = new LeeCode_448();
        List<Integer> disappearedNumbers = leeCode448.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
