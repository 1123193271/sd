package com.study.xyl._27_leecCode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 11231
 * @date 2024/9/11 19:08
 */
public class Q_2047 {

    public static int countValidWords(String sentence) {
        int count = 0;
        Pattern p = Pattern.compile("[a-z]+-?[a-z]+[!.,]?|[a-z]*[!.,]?");
        String[] split = sentence.trim().split("\\s+");
        for (String s : split) {
            Matcher matcher = p.matcher(s);
            if (matcher.matches()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countValidWords(" o6 t"));

    }
}
