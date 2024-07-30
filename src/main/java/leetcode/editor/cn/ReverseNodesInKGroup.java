package leetcode.editor.cn;//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2309 👎 0


import java.util.List;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(8);
        listNode1.next.next = new ListNode(7);
        listNode1.next.next.next = new ListNode(6);
        listNode1.next.next.next.next = new ListNode(5);
        listNode1.next.next.next.next.next = new ListNode(4);
        ListNode res = solution.reverse(listNode1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            // 哨兵
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // 记录被分割链表的前一个节点
            ListNode pre = dummy;
            // 记录被分割链表的尾节点
            ListNode tail = dummy;
            while (tail.next != null) {
                for (int i = 0; tail != null && i < k; i++) {
                    tail = tail.next;
                }
                // todo 不够反转了
                if (tail == null) {
                    break;
                }
                ListNode start = pre.next;
                ListNode next = tail.next;
                tail.next = null;
                // pre 是反正链表之前的节点，需要与反转后的连接上
                pre.next = reverse(start);
                // todo
                start.next = next;
                pre = start;
                tail = pre;
            }

            return dummy.next;
        }

        public ListNode reverse(ListNode node) {
            if (node == null) {
                return node;
            }
            ListNode pre = null;
            ListNode temp = node;
            while (temp != null) {
                ListNode next = temp.next;
                temp.next = pre;
                pre = temp;
                temp = next;
            }
            return pre;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}