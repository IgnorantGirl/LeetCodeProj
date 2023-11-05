package com.hui.Top100;

public class ListNodeIssues {


    /**
     * 92.反转链表Ⅱ
     * 思想：
     * 1.使用一个虚拟节点 指向头节点，避免复杂情况的讨论
     * 2.使用pre指针，指向需要反转left前面的元素
     * 3.对left->right 区间内的元素进行反转
     * @param head
     * @param left
     * @param right
     * @return 反转后的链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i=0;i<left-1;i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i=left;i<right;i++){
            // 反转链表做法
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return  dummyNode.next;
    }

}
/**
 * Definition for singly-linked list.
 *  */
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
