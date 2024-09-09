package com.study.xyl._24_Code;

import java.util.Arrays;

/**
 * 给定一个字符串s, 将这个字符串分割成若干字串，要求每个字串都是回文的
 * 给出最少的分割次数
 */
public class MinCutPalindrome {
    public static void main(String[] args) {
        String randomString = getRandomString(1000);
        int i = minCut(randomString);
        System.out.println(i);
    }

    private static String getRandomString(int length) {
        String abc = "abcdefg";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(abc.charAt((int)(7 *Math.random())));
        }
        return stringBuilder.toString();
    }

    public static int minCut(String s) {
        int length = s.length();
        int[] dp = new int[length];
        //判断子串[i...j]是否是回文串
        boolean[][] palindrome = new boolean[length][length];
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                //如果i和j指向的字符不一样，那么dp[i][j]就不能构成回文串
                if (s.charAt(i) != s.charAt(j))
                    continue;
                palindrome[i][j] = j - i <= 2 || palindrome[i + 1][j - 1];
            }
        }
        //字符串s的回文子串最大也只能是字符串的长度，这里都默认初始化为最大值
        Arrays.fill(dp, length);
        for (int i = 0; i < length; i++) {
            //如果字串s[0,i]本身是回文的，就不需要分割
            if (palindrome[0][i]) {
                dp[i] = 0;
            } else {
                //否则就要分割，找出最小的分割方案
                for (int j = 0; j <= i; ++j) {
                    if (palindrome[j][i])
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[length - 1];
    }
}
