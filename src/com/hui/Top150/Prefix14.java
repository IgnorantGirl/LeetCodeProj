package com.hui.Top150;

public class Prefix14 {
    public static void main(String[] args) {
        String[] strings = {"aaa", "aaa","aa"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        String temp = strs[0];
        String res = "";

        for (int i = 1; i < strs.length; i++) {
            String cur = "";
            String pre = "";
            String str = strs[i];
            for (int j = 0; j < temp.length() && j < str.length(); j++) {
                if (temp.charAt(j) == str.charAt(j)) {
                    cur += temp.charAt(j);
                } else {
                    break;
                }
            }
            if(cur!=""){
                if(res ==""){
                    res = cur;
                }else{
                    res = res.length()<cur.length()?res:cur;
                }}else{
                res = "";
                break;
            }
        }
        return strs.length == 1 ? strs[0] : res;
    }
}
