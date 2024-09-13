package com.study.xyl._27_leecCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 11231
 * @date 2024/9/12 19:01
 */
public class Q_1111 {

    public int[] maxDepthAfterSplit(String seq) {
        int[] split = new int[seq.length()];
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] charArray = seq.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                if (stack1.isEmpty() || stack1.peek() == ')') {
                    stack1.push(charArray[i]);
                    split[i] = 1;
                } else if (stack2.isEmpty() || stack2.peek() == ')') {
                    stack2.push(charArray[i]);
                    split[i] = 0;
                } else {
                    if (stack1.size() > stack2.size()) {
                        stack2.push(charArray[i]);
                        split[i] = 0;
                    } else {
                        stack1.push(charArray[i]);
                        split[i] = 1;
                    }
                }
            } else {
                //')'
                if (!stack1.isEmpty() && stack1.peek() == '(') {
                    stack1.push(charArray[i]);
                    stack1.pop();
                    stack1.pop();
                    split[i] = 1;
                } else if (!stack2.isEmpty() && stack2.peek() == '(') {
                    stack2.push(charArray[i]);
                    stack2.pop();
                    stack2.pop();
                    split[i] = 0;
                }
            }
        }
        return split;
    }

    public static void main(String[] args) {
        Q_1111 q1111 = new Q_1111();
        System.out.println(Arrays.toString(q1111.maxDepthAfterSplit(new String("(((()))((())))"))));
    }
}
