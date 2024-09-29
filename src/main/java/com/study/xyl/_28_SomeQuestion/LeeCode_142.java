package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 18:12
 */
public class LeeCode_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        do {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
            if (p2 == null) {
                return null;
            }
        } while (p1 != p2);
        while (p2 != head) {
            p2 = p2.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeeCode_142 leeCode142 = new LeeCode_142();
        ListNode listNode = new ListNode(new int[]{1,2}, 0);
        System.out.println(leeCode142.detectCycle(listNode));
    }

}
