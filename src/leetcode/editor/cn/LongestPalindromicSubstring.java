package leetcode.editor.cn;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics 字符串 动态规划 👍 7130 👎 0

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.printf("str:" + solution.longestPalindrome("aba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome1(String s) {
            int sLen = s.length();
            int maxLen = 1;
            int len = 0;
            int start = 0;
            int left = 0, right = 0;
            for (int i = 0; i < sLen; i++) {
                left = i - 1;
                right = i + 1;
                // 处理i与left相等的情况
                while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                    left--;
                    len++;
                }
                // 处理i与right相等的情况
                while (right < sLen && s.charAt(i) == s.charAt(right)) {
                    right++;
                    len++;
                }
                // 处理left与right相等的情况
                while (left >= 0 && right < sLen && s.charAt(left) == s.charAt(right)) {
                    right++;
                    left--;
                    len += 2;
                }
                // 更新长度和起始位置
                if (len > maxLen) {
                    maxLen = len;
                    start = left + 1;
                }
//                maxLen = Math.max(maxLen, len);
//                start = left+1;
                // 重置长度
                len = 1;
            }
            return s.substring(start, start + maxLen);
        }

        public String longestPalindrome(String s) {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            // dp动态数字比较的是 第l个元素和第r个元素之内的元素是否为回文串
            // 如果dp[l][r] 相同 在差距在2以内 说明为 aba 、bb 这种形式 可以直接判断为回文串
            // 在l与r差超过2时，需要根据其 前面的结果 dp[l+1][r-1]  babab 即 开头结尾的b 需要依据 内部aba的结果
            int maxLen = 1;
            int start = 0;
            // 从1开始遍历为其右边
            for (int r = 1; r < len; r++) {
                for (int l = 0; l < len; l++) {
                    if (s.charAt(l) == s.charAt(r)
                            && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxLen = r - l + 1;
                            start = l;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  