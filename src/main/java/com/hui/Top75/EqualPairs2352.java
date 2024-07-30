package com.hui.Top75;

import java.util.*;

public class EqualPairs2352 {
    public void doSomething()throws ArithmeticException{
        System.out.println();
    }

    final static int age = 18;

    static int test2 (final StringBuilder arr) {

        try {
            return 112;
        }
        finally {
            System.out.println("即使 try 块有 return，finally 块也会执行");
            return 252;
        }
    }

    public static void main(String[] args) {
        EqualPairs2352 ett = new EqualPairs2352();
        ett.doSomething();


        List<Integer> values = Arrays.asList(1,2,3);
        System.out.println(values);
        StringJoiner stringJoiner = new StringJoiner(",","(",")");

        for (Integer value:values){
            stringJoiner.add(value.toString());
        }
        System.out.println(stringJoiner.toString());

    }


    public static int equalPairs(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        Map<List<Integer>, Integer> maps = new HashMap<>();
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(grid[i][j]);
            }
            maps.put(list, maps.getOrDefault(list, 0) + 1);
        }
        for (int j = 0; j < col; j++) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < row; i++) {
                list.add(grid[i][j]);
            }
            if (maps.containsKey(list)) {
                res += maps.get(list);
            }
        }

        return res;
    }
}
