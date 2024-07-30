package leetcode.editor.cn;  //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2871 👎 0


import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        List<List<Integer>> result = solution.permute(new int[]{1,2,3});
        System.out.println(result.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] isUsed = new boolean[len];
            dfs(path,0,len,nums,isUsed);
            return res;
        }

        public void dfs(List<Integer> list, int depth, int len, int[] nums,boolean[] isUsed) {
            if (depth == len) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < len; i++) {
                // 已经加入过的
                if(isUsed[i]){
                    continue;
                }
                list.add(nums[i]);
                isUsed[i] = true;
                dfs(list, depth + 1, len, nums,isUsed);
                isUsed[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}