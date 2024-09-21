package com.study.xyl._28_SomeQuestion;

/**
 * @author 11231
 * @date 2024/9/13 16:36
 */
public class LeeCode_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode ret = new ListNode();
        ListNode p = ret;
        while (list1 != null || list2 != null ) {
            if (list2 == null) {
                p.next = list1;
                list1 = list1.next;
            } else if (list1 == null) {
                p.next = list2;
                list2 = list2.next;
            } else {
                if (list1.val < list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
            }
            p = p.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {

    }
}
