package com.hui.Top100;

import java.util.HashMap;
import java.util.Map;

public class TreeNodeIssues {

    public static void main(String[] args) {
        Map<Integer,Integer> maps = new HashMap<>();
        maps.put(null, null);
        System.out.println(maps.get(null));
    }
}
