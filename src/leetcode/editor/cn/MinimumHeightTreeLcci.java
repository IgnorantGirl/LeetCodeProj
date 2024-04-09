package leetcode.editor.cn;

//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。 
//示例:
// 给定有序数组: [-10,-3,0,5,9], 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：     
//      0          / \  -3 9  / /  -10 5 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 160 👎 0

public class MinimumHeightTreeLcci {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTreeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(0, nums.length - 1, nums);
        }

        public TreeNode dfs(int start, int end, int[] nums) {
            if (start > end) {
                return null;
            }
            int mid = (start + end + 1) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = dfs(start, mid - 1, nums);
            node.right = dfs(mid + 1, end, nums);

            return node;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
  