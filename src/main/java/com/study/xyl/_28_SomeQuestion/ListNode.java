package com.study.xyl._28_SomeQuestion;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      ListNode(int[] nums) {
            this.val = nums[0];
            ListNode p = this;
            for (int i = 1; i < nums.length; i++) {
                  p.next = new ListNode(nums[i]);
                  p = p.next;
            }
      }

      /**
       * 有环列表
       * @param nums 列表数组
       * @param pos 环节点
       */
      ListNode(int[] nums, int pos) {
            this.val = nums[0];
            ListNode p = this;
            ListNode posNode = null;
            for (int i = 1; i < nums.length; i++) {
                  p.next = new ListNode(nums[i]);
                  if (i == pos) {
                        posNode = p.next;
                  }
                  p = p.next;
                  if (i == nums.length - 1) {
                        p.next = posNode;
                  }
            }
      }
}
