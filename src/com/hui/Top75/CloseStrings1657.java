package com.hui.Top75;

import java.util.Arrays;

public class CloseStrings1657 {

    public static void main(String[] args) {
        System.out.println(closeStrings("abbzzca", "babzzcz"));
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int n = word1.length();
        int m = word2.length();
        if (n != m) return false;
        for (int i = 0; i < n; i++) {
            arr1[word1.charAt(i) - 'a']++;
            arr2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr2.length; i++) {
            if ((arr1[i] == 0 && arr2[i] != 0) || (arr1[i] != 0 && arr2[i] == 0))
                return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }
}
