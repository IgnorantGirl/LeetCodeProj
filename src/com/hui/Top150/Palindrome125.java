package com.hui.Top150;

public class Palindrome125 {
    public static void main(String[] args) {
        // s="A man, a plan , a canal: Panama"
        // s = "race a car"
        boolean res = isPalindrome1("A man, a plan , a canal: Panama");
        System.out.println(res);
        res = isPalindrome("race a car");
        System.out.println(res);
    }

    public static boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        s = s.replaceAll("[^a-z]", "");
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) == s.charAt(len - 1 - i)) {
                count++;
            }
        }
        return count == len / 2;
    }

    public static boolean isPalindrome1(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.trim().toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }
        int count = 0;
        int len = builder.length();
        for (int i = 0; i < len / 2; i++) {
            if (builder.charAt(i) == builder.charAt(len - 1 - i)) {
                count++;
            }
        }
        return count == len / 2;
    }
}
