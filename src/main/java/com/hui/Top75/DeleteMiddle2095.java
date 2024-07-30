package com.hui.Top75;

public class DeleteMiddle2095 {
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len == 1) return null;
        temp = head;
        for (int i = 0; i < (len / 2 - 1); i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    public ListNode deleteMiddle2(ListNode head) {
        if(head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        return head;
    }


}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
