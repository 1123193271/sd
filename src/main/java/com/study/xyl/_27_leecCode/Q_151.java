package com.study.xyl._27_leecCode;

/**
 * @author 11231
 * @date 2024/9/11 18:48
 */
public class Q_151 {

    public static String reverseWords(String str) {
        return reverseWordsTrim(str.trim());
    }

    public static String reverseWordsTrim(String str) {
        StringBuilder s = new StringBuilder();
        String[] split = str.split(" +");
        for (int i = split.length; i > 0 ; i--) {
            s.append(split[i-1]).append(" ");
        }
        return s.deleteCharAt(s.length()-1).toString();
    }

    public static void main(String[] args) {
        reverseWords(" a good   example   ");
    }
}
