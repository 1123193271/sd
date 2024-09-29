package com.study.xyl._28_SomeQuestion_1;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author 11231
 * @date 2024/9/23 10:44
 */
public class LeeCoe_394 {

    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for (char c : charArray) {
            if (c != ']') {
                stack.push(c);
            } else {
                while (stack.peek() != '[') {
                    temp.push(stack.pop());
                }
                stack.pop();
                int i = 0;
                int num = 0;
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    num += Integer.parseInt(stack.pop().toString()) * (Math.pow(10,i));
                    i++;
                }
                StringBuilder str = new StringBuilder();
                while (!temp.empty()) {
                    str.append(temp.pop());
                }
                for (int j = 0; j < num; j++) {
                    for (char c1 : str.toString().toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (Character character : stack) {
            ret.append(character);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        LeeCoe_394 LeeCoe_394 = new LeeCoe_394();
        LeeCoe_394.decodeString(s);
    }
}
