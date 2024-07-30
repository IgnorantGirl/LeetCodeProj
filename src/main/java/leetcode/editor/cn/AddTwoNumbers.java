package leetcode.editor.cn;

//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
// 
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
//
// Related Topics 递归 链表 数学 👍 10485 👎 0

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        ListNode res = solution.addTwoNumbers(listNode1, listNode2);
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
        boolean flag = false;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(-1);
            ListNode curL1 = l1;
            ListNode curL2 = l2;
            ListNode tempRes = res;

            while (curL1 != null && curL2 != null) {
                int sum = 0;
                if (flag) {
                    sum += 1;
                }
                sum = sum + curL1.val + curL2.val;
                flag = sum / 10 != 0;
                int value = sum % 10;
                tempRes.next = new ListNode(value);

                curL1 = curL1.next;
                curL2 = curL2.next;
                tempRes = tempRes.next;
            }
            while (curL1 != null) {

                tempRes.next = new ListNode(getSumValue(flag, curL1));
                curL1 = curL1.next;
                tempRes = tempRes.next;
            }
            while (curL2 != null) {
                tempRes.next = new ListNode(getSumValue(flag, curL2));
                tempRes = tempRes.next;
                curL2 = curL2.next;
            }

            // 特殊处理 最后的进位
            if (flag) {
                tempRes.next = new ListNode(1);
            }
            return res.next;
        }

        private int getSumValue(boolean flag, ListNode cur) {
            int sum = 0;
            if (flag) {
                sum += 1;
            }
            sum = sum + cur.val;
            this.flag = sum / 10 != 0;
            return sum % 10;
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

  