package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 18:13
 */
public class LeeCode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        while (p1.next != null) {
            p1 = p1.next;
        }
        p1.next = headB;

        //准换成找环入口，找不到就是没相交
        ListNode p2 = headA;
        ListNode p3 = headA;
        do {
            p2 = p2.next;
            p3 = p3.next;
            if (p3 == null) {
                p1.next = null;
                return null;
            }
            p3 = p3.next;
            if (p3 == null) {
                p1.next = null;
                return null;
            }
        } while (p2 != p3);
        while (p3 != headA) {
            p3 = p3.next;
            headA = headA.next;
        }
        p1.next = null;
        return headA;
    }
}
