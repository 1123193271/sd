package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 18:19
 */
public class LeeCode_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LeeCode_206 leeCode206 = new LeeCode_206();
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        leeCode206.reverseList(listNode);
    }




}
