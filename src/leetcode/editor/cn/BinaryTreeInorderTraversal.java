package leetcode.editor.cn;

//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2066 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeInorderTraversal().new Solution();
          TreeNode root = new TreeNode(1);
          root.right = new TreeNode(2);
          root.right.left = new TreeNode(3);
          solution.inorderTraversal(root);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res  = new ArrayList<>();

    /**
     * 遍历方式
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if(root == null) {
            return res;
        }

        if(root.left!=null){
            inorderTraversal(root.left);
        }
        res.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return res;
    }

    /**
     * 迭代 栈管理
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root!=null) {
            // 不断往左子树走呀走
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else  {
                // 左子数都走完了 拿出一个
                // 将其结果加入result当中
                TreeNode curNode = stack.pop();
                result.add(curNode.val);
                // 遍历其右子树
                root = curNode.right;
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
static class TreeNode {
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
  