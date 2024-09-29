package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/23 9:48
 */
public class LeeCode_234 {

    private ListNode frontNode;

    public boolean isPalindrome(ListNode head) {
        frontNode = head;
        return recursiveCheck(head);
    }

    public boolean recursiveCheck(ListNode head) {
        if (head != null) {
            if (!recursiveCheck(head.next)) {
                return false;
            }
            if (frontNode.val != head.val) {
                return false;
            }
            frontNode = frontNode.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
