package com.study.xyl._28_SomeQuestion;

import java.util.List;

public class LeetCode_1436 {
    public String destCity(List<List<String>> paths) {
        String ans = paths.get(0).get(0);
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).get(0).equals(ans)) {
                ans = paths.get(i).get(1);
                i = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
