package leetcode.editor.cn;

//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10044 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // int res = solution.lengthOfLongestSubstring1("ababababc");
        int res1 = solution.lengthOfLongestSubstring("abababc");

        // System.out.println(res +" / " +res1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring1(String s) {
            int len = s.length();
            // 边缘case
            if (len == 0 || len == 1) {
                return len;
            }
            int left = 0, right = 1;
            int res = 0;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(0));
            while (right < len) {
                char rightChar = s.charAt(right);
                if (!set.contains(rightChar)) {
                    set.add(rightChar);
                    right++;
                    continue;
                }
                // 如果包含rightChar，说明有重复，更新结果
                res = Math.max(res, set.size());
                set.clear();
                left++;
                set.add(s.charAt(left));
                right = left + 1;
            }
            res = Math.max(res, set.size());
            return res;
        }

        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            // 边缘case
            if (len == 0 || len == 1) {
                return len;
            }
            Map<Character, Integer> maps = new HashMap<>();
            int res = 0;
            int left = 0;
            for (int i = 0, right = 0; right < len; i++, right++) {
                char c = s.charAt(i);
                if (maps.containsKey(c)) {
                    left = Math.max(left, maps.get(c));
                }
                maps.put(c, right + 1);
                res = Math.max(res, right - left + 1);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
  