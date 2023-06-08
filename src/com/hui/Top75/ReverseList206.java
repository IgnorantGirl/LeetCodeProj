package com.hui.Top75;

public class ReverseList206 {

    public ListNode reverseList206(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }
}
