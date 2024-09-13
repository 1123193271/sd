package com.study.xyl._27_leecCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 11231
 * @date 2024/9/11 17:38
 */
public class Q_14 {

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            prefix = longestPrefixTwoString(prefix, str);
        }
        return prefix;
    }

    public static String longestPrefixTwoString(String str1, String str2) {
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (true) {
            if (i < str1.length() && i < str2.length() &&
                    str1.charAt(i) == str2.charAt(i)) {
                prefix.append(str1.charAt(i));
                i++;
            } else {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"fsafda", "fsasd", "fsafgdsfds"}));
    }
}
