package com.hui.Top150;


import java.util.HashMap;
import java.util.Map;

public class CanConstruct383 {
    public static void main(String[] args) {
        // aa  aab T / aa ab F
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct1("aa", "aab"));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> maps = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!maps.containsKey(c)) {
                return false;
            } else {
                if (maps.get(c) < 1) return false;
                maps.put(c, maps.get(c) - 1);
            }
        }
        return true;
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] magazineInt = new int[26];
        for (char c : magazine.toCharArray()) {
            magazineInt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            magazineInt[c - 'a']--;
            if (magazineInt[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
