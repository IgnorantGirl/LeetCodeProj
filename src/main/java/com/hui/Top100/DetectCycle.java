package com.hui.Top100;

/**
 * 142:环形链表Ⅱ
 */
public class DetectCycle {

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(2);
        Node node2 = new Node(0);
        Node node3 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Node res = detectCycle(head);
        System.out.println(res.val);
    }

    public static Node detectCycle(Node head) {
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            if(slow!=head && slow == fast){
                Node prev = head;
                while(prev!=slow){
                    prev = prev.next;
                    slow = slow.next;
                }
                return prev;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

}

class Node{
    int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}


