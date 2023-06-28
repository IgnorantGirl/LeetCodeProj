package com.hui.Top75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurrences1207 {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{0,2,2,1,1,3}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> maps = new HashMap<>();
        for(int a:arr){
            maps.put(a,maps.getOrDefault(a,0)+1);
        }
        return maps.size() == new HashSet<>(maps.values()).size();
    }
}
