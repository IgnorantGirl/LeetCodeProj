package com.hui.Top150;

public class IsAnagram242 {
    public static void main(String[] args) {
        // anagram   nagarat
        System.out.println(isAnagram("anagram", "nagarat"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sInt = new int[26];
        int[] tInt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sInt[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tInt[c - 'a']++;
        }
        for (int i = 0; i < sInt.length; i++) {
            if (sInt[i] != tInt[i]) return false;
        }
        return true;
    }
}
