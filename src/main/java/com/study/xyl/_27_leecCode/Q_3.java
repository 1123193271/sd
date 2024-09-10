package com.study.xyl._27_leecCode;

/**
 * @author 11231
 * @date 2024/9/10 18:04
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 *  的长度。
 */
public class Q_3 {

    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int ret = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                boolean flag = false;
                for (int k = i; k <= j; k++) {
                    if (charArray[k] == charArray[j]) {
                        if (k == j) {
                            ret = Math.max(ret, j - i + 1);
                        }else {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
