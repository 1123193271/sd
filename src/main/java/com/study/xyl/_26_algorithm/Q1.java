package com.study.xyl._26_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 11231
 * @date 2024/9/9 18:59
 */
public class Q1 {
    public static void strListSplit() {
        int arg = 0;
        String str = null;
        System.out.println("请输入参数：");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext())
            arg = Integer.parseInt(scanner.nextLine());
        System.out.println("请输入字符串");
        if (scanner.hasNext())
            str = scanner.nextLine();
        assert str != null;
        String[] split = str.split("-");
        List<String> newSplit = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                newSplit.add(split[i]);
                continue;
            }
            newSplit.addAll(splitString(split[i], arg));
        }

        System.out.println(String.join("-", newSplit));
    }

    public static List<String> splitString(String str, int arg) {
        //根据参数大小分割str,并且遵守规则大小写一致
        List<String> list = new ArrayList<>();
        for (int i = 0; i < (str.length()+arg-1)/arg; i++) {
            list.add(str.substring(arg * i, Integer.min(arg * i + arg, str.length())));
        };
        List<String> collect = list.stream().map(item -> {
            char[] charArray = item.toCharArray();
            char[] charArray1 = item.toUpperCase().toCharArray();
            char[] charArray2 = item.toLowerCase().toCharArray();
            int a = 0, b = 0;
            for (int i = 0; i < charArray.length; i++) {
                a += Math.abs(charArray1[i] - charArray[i]);
                b += Math.abs(charArray2[i] - charArray[i]);
            }
            return new String(a > b ? charArray2 : charArray1);
        }).collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        strListSplit();
    }


}
