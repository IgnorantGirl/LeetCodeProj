package leetcode.editor.cn;  //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2279 👎 0


import leetcode.editor.cn.ReverseLinkedList;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(8);
        listNode1.next.next = new ListNode(7);
        listNode1.next.next.next = new ListNode(6);
        listNode1.next.next.next.next = new ListNode(5);
        listNode1.next.next.next.next.next = new ListNode(4);
        ListNode res = solution.sortList(listNode1);
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
        public ListNode sortList(ListNode head) {
            // 边界条件
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            // 通过快慢指针 找到链表的终中点位置
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 后半部分
            ListNode temp = slow.next;
            // 截断链表
            slow.next = null;
            // 自底向下 分而治之 递归
            ListNode left = sortList(head);
            ListNode right = sortList(temp);

            ListNode res = new ListNode(-1);
            ListNode cur = res;
            // 排序
            while (left != null && right != null) {
                if(left.val <= right.val){
                    cur.next = left;
                    left = left.next;
                }else{
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            // 左右链表还剩下的元素
            cur.next = left!=null?left:right;
            return res.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ListNode {
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
}