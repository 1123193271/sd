package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/23 9:53
 */
public class LeeCode_876 {

    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (s.next != null && f.next != null) {
            f = f.next;
            if (f.next != null) {
                f = f.next;
                s = s.next;
            } else {
                s = s.next;
            }
        }
        return s;
    }

    public static void main(String[] args) {

    }
}
