package com.hui.Top150;

import java.util.HashSet;
import java.util.Set;

public class HappySum {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> sets = new HashSet<>();
        int result = getNext(n);
        while(result!=1 && (!sets.contains(result))){
            sets.add(result);

            result = getNext(result);
        }
        return result == 1;
    }

    public static int getNext(int n){
        int res = 0;
        while(n>0){
            int a = n%10;
            n = n/10;
            res = res + a * a;
        }
        return res;
    }
}
