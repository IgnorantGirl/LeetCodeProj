package com.hui.Top150;

public class Palindrome125 {
    public static void main(String[] args) {
        // s="A man, a plan , a canal: Panama"
        // s = "race a car"
        boolean res = isPalindrome("A man, a plan , a canal: Panama");
        System.out.println(res);
        res = isPalindrome("race a car");
        System.out.println(res);
    }

    public static boolean isPalindrome(String s){
        s = s.trim().toLowerCase();
        s = s.replaceAll("[^a-z]","");
        int len = s.length();
        int count = 0;
        for(int i=0;i<len/2;i++){
            if(s.charAt(i) == s.charAt(len-1-i)){
                count++;
            }
        }
        return count == len/2;
    }
}
