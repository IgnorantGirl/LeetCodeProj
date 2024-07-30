package com.hui.Top150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinWindow76 {
    public static void main(String[] args) {
        //输入：s = "ADOBECODEBANC", t = "ABC"
        //输出："BANC"
        System.out.println(minWindow("AA", "AA"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, start = 0;
        int vaild = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }

            while (vaild == need.size()) {
                if (right - left < len) {
                    // 更新起始点和长度
                    start = left;
                    len = right - left;
                }
                // 要移除的元素
                char leftChar = s.charAt(left);
                left++;
                if (need.containsKey(leftChar)) {
                    if (Objects.equals(need.get(leftChar), window.get(leftChar)))
                        vaild--;
                    window.put(leftChar, window.get(leftChar) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
