package com.hui.Top150;

import java.util.*;

public class GroupWords49 {
    public static void main(String[] args) {
        //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if (!maps.containsKey(String.valueOf(chars))) {
                maps.put(String.valueOf(chars), new ArrayList<>());
            }
            maps.get(String.valueOf(chars)).add(strs[i]);
        }
        return new ArrayList<>(maps.values());
    }
}
