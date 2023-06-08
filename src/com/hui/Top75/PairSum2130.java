package com.hui.Top75;

public class PairSum2130 {
    public static int pairSum2130(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null&&fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
        }
        // 反转后半链表
        ListNode last = slow.next;
        while (last.next!=null){
            ListNode next = last.next;
            last.next = next.next;
            next.next = slow.next;
            slow.next = next;
        }
        int max = Integer.MIN_VALUE;
        ListNode x = head;
        ListNode y = slow.next;
        while (y!=null){
            max = Math.max(y.val+ x.val,max);
            x = x.next;
            y = y.next;
        }
        return max;
    }
}
