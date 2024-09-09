package com.study.xyl._24_Code;

/**
 * 给定一个字符串数组words, 找出并返回length(words[i])*length(words[j])的最大值
 * 并且这两个单词不含有公共字母，如果不存在这样的两个单词，返回0
 * 注意:单词中仅包含小写字母
 */
public class MaxProduct {
    public static void main(String[] args) {
        String[] words = {"hello", "word", "foo", "case", "Thread"};
        System.out.println(maxMultipleLength(words));
    }

    public static int maxMultipleLength(String[] words) {
        int length = words.length;
        //记录每个字符串有哪些字母
        int[] bits = new int[length];
        int ans = 0;
        for (int i = 0; i < length; i++) {
            //标记但钱字符串有哪些符号
            for (char ch : words[i].toCharArray()) {
                bits[i] |= 1 << (ch - 'a');
            }
            //如果当前字符串和之前的字符串没有公共的字母，就计算他们的乘积
            //只保留最大值即可
            for (int j = 0; j < i; j++) {
                //如果结果为0，则表示他们没有公共的字母
                if ((bits[i] & bits[j]) == 0) {
                    ans = Math.max(ans, (words[i].length() * words[j].length()));
                    System.out.println(ans + ":" + i + "*" + j);
                }
            }
        }
        return ans;
    }
}
