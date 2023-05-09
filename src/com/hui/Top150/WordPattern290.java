package com.hui.Top150;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    //输入: pattern = "abba", s = "dog cat cat dog"
    //输出: true
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> maps = new HashMap<>();
        String[] charArray = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(maps.containsKey(c)){
                if(!charArray[i].equals(maps.get(c))){
                    return false;
                }
            }else{
                maps.put(c,charArray[i]);
            }
        }
        return true;
    }
}
