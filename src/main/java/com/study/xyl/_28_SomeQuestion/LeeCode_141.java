package com.study.xyl._28_SomeQuestion;

import java.util.HashSet;

/**
 * @author 11231
 * @date 2024/9/13 18:04
 */
public class LeeCode_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        do {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return false;
            }
            p2 = p2.next;
            if (p2 == null) {
                return false;
            }
        } while (p1 != p2);
        return true;
    }

    public static void main(String[] args) {
        LeeCode_141 leeCode141 = new LeeCode_141();
    }
}
