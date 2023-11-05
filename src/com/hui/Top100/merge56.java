package com.hui.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge56 {

    public static void main(String[] args) {
        int[][] test = {{1,3},{2,6},{8,10},{15,18},{3,5},{14,16}};
        merge(test);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{ return a[0]-b[0];});
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int L = intervals[i][0], R = intervals[i][1];
            if(list.size() == 0 || list.get(list.size()-1)[1]<L){
                list.add(new int[]{L,R});
            }else{
                list.get(list.size()-1)[1] = Math.max(R,list.get(list.size()-1)[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
