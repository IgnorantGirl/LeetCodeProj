package leetcode.editor.cn;

//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2801 👎 0

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode[] test= new ListNode[]{null};
        solution.mergeKLists(test);
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
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            });

            for (ListNode list : lists) {
                if (list != null) {
                    queue.offer(list);
                }
            }

            ListNode res = new ListNode(-1);
            ListNode temp = res;
            while (!queue.isEmpty()){
                ListNode node = queue.poll();
                temp.next = node;
                if(node.next!=null){
                    queue.offer(node.next);
                }
                temp = temp.next;
            }

//            for (int i = 0; i < lists.length-1; i++) {
//                res.next = merge(lists[i],lists[i+1]);
//            }
            return res.next;
        }

        public ListNode merge(ListNode node1, ListNode node2) {
            if (node1 == null || node2 == null) {
                return node1 == null ? node2 : node1;
            }
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    pre.next = node1;
                    node1 = node1.next;
                } else {
                    pre.next = node2;
                    node2 = node2.next;
                }
                pre = pre.next;
            }
            if (node1 != null) {
                pre.next = node1;
            }
            if (node2 != null) {
                pre.next = node2;
            }
            return dummy.next;
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
  