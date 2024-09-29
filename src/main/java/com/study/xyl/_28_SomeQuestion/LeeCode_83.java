package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 16:39
 */
public class LeeCode_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeeCode_83 leeCode83 = new LeeCode_83();
        ListNode listNode = new ListNode(new int[]{1, 1, 2});
        leeCode83.deleteDuplicates(listNode);
    }
}
