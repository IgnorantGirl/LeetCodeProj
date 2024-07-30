package com.hui.Offer;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList35 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> maps = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            maps.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            maps.get(cur).next = maps.get(cur.next);
            maps.get(cur).random = maps.get(cur.random);
            cur = cur.next;
        }
        return maps.get(head);
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 1.构建复制的链表
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        // 2.构建random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 3.拆分
        Node oldHead = head, res = head.next;
        cur = head.next;
        while (cur.next != null) {
            oldHead.next = oldHead.next.next;
            cur.next = cur.next.next;
            oldHead = oldHead.next;
            cur = cur.next;
        }
        oldHead.next = null;
        return res;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}