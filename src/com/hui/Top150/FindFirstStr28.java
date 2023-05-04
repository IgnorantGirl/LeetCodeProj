package com.hui.Top150;

public class FindFirstStr28 {
    public static void main(String[] args) {
        // sadbutsad  sad  0
        System.out.println(strStr("butsad", "sad"));
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
}
