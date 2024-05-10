package leetcode.editor.cn;

//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 1320 👎 0

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        int result = solution.countSubstrings("abba");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countSubstrings(String s) {
            int len = s.length();
            int res = 0;
            for (int i = 0; i < len; i++) {
                // 奇数情况
                res = helper(i,i,len,res,s);
                // 偶数情况
                res = helper(i,i+1,len,res,s);
            }
            return res;
        }

        // 中心扩散
        public int helper(int i, int j, int n, int res, String str) {
            while (i >= 0 && j < n) {
                if (str.charAt(i) != str.charAt(j)) break;
                res++;
                i--;
                j++;
            }
            return res;
        }














        public int countSubstrings1(String s) {
            int res = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                res = exceedCharacter(i, i, n, s, res);
                res = exceedCharacter(i, i + 1, n, s, res);

            }
            return res;
        }

        public int exceedCharacter(int i, int j, int len, String str, int res) {
            while (i >= 0 && j < len && str.charAt(i) == str.charAt(j)) {
                i--;
                j++;
                res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  