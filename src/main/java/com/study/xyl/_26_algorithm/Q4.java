package com.study.xyl._26_algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 11231
 * @date 2024/9/9 19:50
 * 子序列判定
 */
public class Q4 {
    public static void sequenceCondemn(String s, String t) {
        if (s.length() > t.length()) {
            System.out.println(Boolean.FALSE);
            return;
        }
        for (int i = 0,j = 0; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j =j - i + 1;
                i = 0;
            }

            if (i == s.length()) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }

    private static int[] computePrefixArray(String pattern) {
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

//    public static void main(String[] args) {
//        int[] ints = computePrefixArray("aaabbbaaabbb");
//
//        sequenceCondemn("aaabbbaaabbb", "aaaabbbaaabbb");
//
////        Scanner scanner = new Scanner(System.in);
////        while(scanner.hasNext()){
////            String next = scanner.nextLine();
////            System.out.println(next);
////        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<Integer> array = new ArrayList<>();
        int a = in.nextInt();
        for (int i = 0; i < a; i++) {
            int b = in.nextInt();
            array.add(b);
        }
        Set<Integer> set = new HashSet<Integer>(array);
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        for(int i : collect) {
            System.out.println(i);
        }

    }

}
