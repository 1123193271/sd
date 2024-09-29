package com.study.xyl._28_SomeQuestion_2;

/**
 * @author 11231
 * @date 2024/9/29 9:24
 */
public class LeeCode_2073 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0){
                    tickets[i]--;
                    ans++;
                }
                if (tickets[k] == 0) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
