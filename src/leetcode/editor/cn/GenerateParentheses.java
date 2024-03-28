package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3541 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n,0,0,"");
            return res;
        }

        /**
         * 深度遍历 获取括号组合
         *
         * @param n          括号数量
         * @param leftCount  左括号数量
         * @param rightCount 右括号数量
         * @param str        本次遍历组合的字符串
         */
        public void dfs(int n, int leftCount, int rightCount, String str) {
            // 当左括号数量 、右括号数量与 给定的括号数量相同时，则表示遍历出来一个结果
            if (leftCount == n && rightCount == n) {
                res.add(str);
                return;
            }
            // 当左括号没有达到 括号数量 可以加左括号
            if (leftCount < n) {
                dfs(n, leftCount + 1, rightCount, str + '(');
            }
            // 当右括号数量<括号数量, 并且左括号数量大于右括号时，说明可以有左括号与右括号匹配，可以加右括号
            if (rightCount < n && leftCount > rightCount) {
                dfs(n, leftCount, rightCount + 1, str + ')');
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  