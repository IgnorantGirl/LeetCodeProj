package com.hui.Top150;

public class FindFirstStr28 {
    public static void main(String[] args) {
        // sadbutsad  sad  0
        System.out.println(strStr1("butsad", "sad"));
        // leetcode leeto  -1
    }

    public static int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m) return -1;
        for (int i = 0; i <= m - n; i++) {
            int a = i;
            int b = 0;
            while (b < n && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == n) return i;
        }
        return -1;
    }

    // KMP算法参考链接:https://www.zhihu.com/question/21923021/answer/281346746
    public static int strStr1(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m) return -1;
        int[] next = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                // 回溯 前后缀
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                // 回溯 前后缀
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i-n + 1;
            }
        }
        return -1;
    }
}
