package com.hui.Offer;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining62 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(10,17));
    }

    public static int lastRemaining(int n,int m){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index = 0;
        while (list.size()>1){
            index = (index-1+m)%n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
