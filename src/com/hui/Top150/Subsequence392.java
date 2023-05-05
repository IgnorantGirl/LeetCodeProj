package com.hui.Top150;

public class Subsequence392 {
    public static void main(String[] args) {
        // s="ace"  t="abcde"
        System.out.println(isSubsequence("ace","abced"));
    }

    public static boolean isSubsequence(String s,String t){
        int count =0;
        for (int i=0,j=0;i<t.length()&&j<s.length();i++){
            if(s.charAt(j)==t.charAt(i)){
                count++;
                j++;
            }
        }
        return count == s.length();
    }
}
