package com.study.xyl._28_SomeQuestion_2;

import java.util.Stack;

/**
 * @author 11231
 * @date 2024/9/27 10:24
 */
public class LeeCode_2516 {
    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int len = s.length();
        int ans = len;
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return -1;
        }

        int l = 0;
        for (int r = 0; r < len; r++) {
            cnt[s.charAt(r) - 'a']--;
            while (l < r && (cnt[0] < k || cnt[1] < k || cnt[2] < k)) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
                ans = Math.min(ans, len - (r - l + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LeeCode_2516 leeCode2516 = new LeeCode_2516();
        System.out.println(leeCode2516.takeCharacters("abc", 1));
    }
}
