package com.study.xyl._24_Code;

import java.util.Objects;

public class KMPAlgorithm {
    //构建部分匹配表
    private int[] computePrefixArray(String pattern) {
        int[] prefixArray = new int[pattern.length()];
        int index = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = prefixArray[index - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(index)) {
                index++;
            }
            prefixArray[i] = index;
        }
        return prefixArray;
    }

    //KMP算法的实现
    public double kmpSearch(String text, String pattern) {
        if (Objects.isNull(pattern)) return 0.0;
        int maxJ = 0;
        int[] prefixArray = computePrefixArray(pattern);
        int i = 0;//i表示text的索引
        int j = 0;//j表示pattern的索引
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                maxJ = Math.max(j, maxJ);
            } else {
                if (j != 0) {
                    j = prefixArray[j-1];//不匹配时，根据部分匹配表移动pattern的位置
                } else {
                    i++;
                }
            }
        }
        //如果pattern全部匹配完了，说明找到了匹配的字串
//        return j == pattern.length();
        return (double) maxJ /pattern.length();
    }
    public static void main(String[] args) {
        KMPAlgorithm kmp = new KMPAlgorithm();
        String text = "ABC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        kmp.kmpSearch(text, null);
    }
}
