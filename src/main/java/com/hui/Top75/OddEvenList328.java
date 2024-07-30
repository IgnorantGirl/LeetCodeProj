package com.hui.Top75;

public class OddEvenList328 {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
