package com.hui.Top100;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 窗口系列题目
 * 1. 使用双指针中的左右指针技巧，初始化 left = right = 0，把索引左闭右开区间 [left, right) 称为一个「窗口」
 * 2. 不断增加right指针，扩大窗口[left,right), 直到符合要求
 * 3. 当符合要求后，则停止增加right, 转向不断增加left指针，缩小窗口 [left, right)
 */
public class WindowIssure {


    public static void main(String[] args) {
        // System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    /**
     * 3.无重复字符的最长子串
     * 思想
     * 1.使用map 以字符为key, 字符个数为value；左右指针(first second)相继移动
     * 2.当字符个数>1时，则说明子串中有重复的字符，从左指针开始遍历 从map中减去其个数，直到不满足循环条件即可
     * 3.否则，则移动右指针即可
     * 4.结果 取 右指针-左指针的长度 与当前最长子串的最大值
     *
     * @param s 字符串 "abcabcbb"
     * @return 最长子串的个数
     */
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 1 || len == 0) return len;
        Map<Character, Integer> maps = new HashMap<>();
        int res = 1;
        int left = 0;
        int right = 0;
        while (right < len) {
            char c = s.charAt(right);
            maps.put(c, maps.getOrDefault(c, 0) + 1);
            right++;
            while (maps.get(c) > 1) {
                char leftChar = s.charAt(left);
                left++;
                maps.put(leftChar, maps.get(leftChar) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }


    /**
     * 438.找到字符串中所有字母异位词
     * 思想：
     * 1.使用两个map 分别存取 子串need及其 字符串的窗口window，以字符为key, 数量为value
     * 2.使用左右指针进行对窗口 扩大和缩小 right-扩大；left-缩小
     * 3.当need与window窗口中元素及其数量都对应上时，则valid++;
     *
     * @param s 字符串 "cbaebabacd"
     * @param p 待寻找异位词的字符串 "abc"
     * @return 返回这些字串的起始索引 [0,6]
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return res;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < sLen) {
            char rightChar = s.charAt(right);
            right++;
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) {
                        res.add(left);
                        valid--;
                    }
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                left++;
            }
        }
        return res;
    }

    /**
     * 76.最小覆盖子串
     * 1.使用两个map 分别存取 子串need及其 字符串的窗口window，以字符为key, 数量为value
     * 2.使用左右指针，进行窗口的扩大和缩小；使用start strLen保存每次能够更新子串的长度和首索引值;使用valid来表示字符串窗口某元素是否匹配子串窗口
     * 3.遍历right,当need窗口中存在该元素时，则将其加入window窗口,并判定子串中该元素的个数是否与窗口window中的元素个数匹配，匹配则valid++
     * 4.当字符串窗口window中元素种类及个数与子串need窗口完全匹配时，则进行窗口收缩 left++
     * 5.窗口收缩时，当right-left< strLen 则更新 首索引值和 strLen长度
     * 6.当只有window与need不匹配时，才继续扩大窗口；不匹配的条件需要满足：①need窗口包含left元素 ②need窗口与window窗口中的left元素个数相等
     * 此时还要注意 即使二者不相等时，但need窗口存在该元素，就需要将window窗口的该元素移除，该情况可能是window窗口中有多个left元素
     *
     * @param s 字符串 "ADOBECODEBANC"
     * @param t 子串 "ABC"
     * @return "BANC"
     */
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        String res = "";
        if (sLen < tLen) return res;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;  // 使用start存储 每次能够更新子串时的 left值，是因为后面子串长度也可能大于前面
        int strLen = Integer.MAX_VALUE;  // 假设子串的长度为 max_value，方便在窗口中对该值进行更新
        while (right < sLen) {
            // 扩大窗口
            char c = s.charAt(right);
            right++;
            // 需要将在need窗口的元素，加入到window中，其他就不用加了
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判定 必须在if里面，否则 get方法会 空指针异常
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            // 判断有效是否为 need的大小，是因为 可能子串中有重复字符 所以不能valid == tLen
            while (valid == need.size()) {
                // 判断是否更新字符串中子串的长度和首索引值
                if (right - left < strLen) {
                    strLen = right - left;
                    start = left;
                }
                // 收缩窗口
                char leftChar = s.charAt(left);
                left++;
                // 无效条件的判定，需要need窗口中包含该字符 且其包含值与窗口包含值相等
                if (need.containsKey(leftChar)) {
                    if (Objects.equals(window.get(leftChar), need.get(leftChar))) {
                        valid--;
                    }
                    // 窗口中字符的移除 需要满足 need窗口中包含该字符，如若不加该判定条件，即将其移到if外面
                    // 则若valid一直没有满足条件--,会导致 window.get获取对象为null
                    window.put(leftChar, window.get(leftChar) - 1);
                }
            }
        }
        return strLen == Integer.MAX_VALUE ? "" : s.substring(start, start + strLen);
    }
}
