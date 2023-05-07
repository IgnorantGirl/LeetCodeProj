package com.hui.Top150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubString3 {
    public static void main(String[] args) {
        //输入: s = "abcabcbb"
        //输出: 3
        lengthOfLongestSubstring("abcabcbb");
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> sets = new HashSet<>();
        int count = 0;
        int right = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //　移除前一个 i相当于左指针
                sets.remove(s.charAt(i - 1));
            }
            while (right < n && (!sets.contains(s.charAt(right)))) {
                sets.add(s.charAt(right));
                right++;
            }
            count = Math.max(count, right - i);
        }
        return count;
    }

    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        int left = 0;
        int count = 0;
        for (int i = 0, right = 0; i < s.length(); i++, right++) {
            char c = s.charAt(i);
            if (maps.containsKey(c)) {
                left = Math.max(left, maps.get(c));
            }
            maps.put(c, right + 1);
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
